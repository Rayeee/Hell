package winter.hell.lock;

import org.springframework.stereotype.Component;
import winter.hell.redis.RedisClient;

import javax.annotation.Resource;

/**
 * Created by Rayee on 16/6/22.
 */
@Component
public class LockServiceImpl implements LockService {

    @Resource
    RedisClient redisClient;

    @Override
    public boolean lock(LockDto lockDto) {

        StringBuilder sb = new StringBuilder();
        sb.append(lockDto.getSysName());
        sb.append(lockDto.getKey());
        String key = sb.toString();
        int expireTime = (int) Math.ceil(Double.valueOf(lockDto.getLockTime()) / 1000);
        long expireAt = lockDto.getLockTime() + System.currentTimeMillis();
        boolean isLock = false;
        boolean setNx = false;
        try {
            setNx = redisClient.setnx(key, String.valueOf(expireAt));
            if (!setNx) {
                //setnx失败，判断是否是由于死锁
                long keyExpireAt = Long.valueOf(redisClient.getByKey(key).toString());
                if (keyExpireAt < System.currentTimeMillis()) {
                    //已经过了过期时间
                    redisClient.delKey(key);
                    redisClient.setnx(key, String.valueOf(expireAt));
                    setNx = true;
                }
            }

            if (setNx) {
                redisClient.expire(key, expireTime);
                isLock = setNx;
            }

        } catch (Exception e) {
            if (setNx && lockDto.isDegrade()) {
                isLock = true;
            }
        }
        return isLock;
    }

    @Override
    public boolean release(String sysName, String key) {
        StringBuilder sb = new StringBuilder();
        sb.append(sysName);
        sb.append(key);
        String redisKey = sb.toString();
        boolean isRelease = false;
        try {
            isRelease = redisClient.delKey(redisKey);
        }catch (Exception e){
            isRelease = false;
        }
        return isRelease;
    }
}

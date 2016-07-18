package winter.hell.redis;

import me.ele.elog.Log;
import me.ele.elog.LogFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Random;

public class RedisLock {

    /** 加锁标志 */
    public static final String LOCKED = "TRUE";
    /** 毫秒与毫微秒的换算单位 1毫秒 = 1000000毫微秒 */
    public static final long MILLI_NANO_CONVERSION = 1000 * 1000L;
    /** 默认超时时间（毫秒） */
    public static final long DEFAULT_TIME_OUT = 1000;
    public static final Random RANDOM = new Random();
    /** 锁的超时时间（秒），过期删除 */
    public static final int EXPIRE = 3 * 60;

    private JedisPool jedisPool;
    private Jedis jedis;
    private String key;
    // 锁状态标志
    private boolean locked = false;

    private static final Log logger = LogFactory.getLog(RedisLock.class);

    /**
     * This creates a RedisLock
     * 
     * @param key key
     * @param jedisPool 数据源
     */
    public RedisLock(String purpose, String key, JedisPool jedisPool) {
        this.key = purpose + "_" + key + "_lock";
        this.jedisPool = jedisPool;
        try {
            this.jedis = this.jedisPool.getResource();
        } catch (Exception e) {
            logger.error("获取redis链接异常", e);
            throw e;
        }
    }

    /**
     * 加锁
     * 应该以：
     * lock();
     * try {
     * doSomething();
     * } finally {
     * unlock()；
     * }
     * 的方式调用
     * 
     * @param timeout 超时时间
     * @param expire 锁的超时时间（秒），过期删除
     * @return 成功或失败标志
     */
    public boolean lock(long timeout, int expire) {
        long nano = System.nanoTime();
        timeout *= MILLI_NANO_CONVERSION;
        try {
            while ((System.nanoTime() - nano) < timeout) {
                if (this.jedis.setnx(this.key, LOCKED) == 1) {
                    logger.debug("往redis里面写库成功，key为:" + this.key);
                    this.jedis.expire(this.key, expire);
                    this.locked = true;
                    return this.locked;
                }
                logger.debug("开始等待：{}", System.currentTimeMillis() - nano);
                this.jedisPool.returnResource(jedis);
                // 短暂休眠，避免出现活锁
                Thread.sleep(30, RANDOM.nextInt(30));
                this.jedis = jedisPool.getResource();
            }
        } catch (Exception e) {
            throw new RuntimeException("Locking error", e);
        } finally {
            this.jedisPool.returnResource(jedis);
        }
        return false;
    }

    /**
     * 解锁
     * 无论是否加锁成功，都需要调用unlock
     * 应该以：
     * lock();
     * try {
     * doSomething();
     * } finally {
     * unlock()；
     * }
     * 的方式调用
     */
    public void unlock() {
        try {
            if (this.locked) {
                this.jedis = this.jedisPool.getResource();
                jedis.del(this.key);
            }
        } catch (Throwable e) {
            logger.error("redis删除键异常,可暂时不处理等键值失效", e);
        } finally {
            try {
                this.jedisPool.returnResource(this.jedis);
            } catch (Throwable e) {
                logger.error("redis释放链接异常", e);
            }
        }
    }
}

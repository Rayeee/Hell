package winter.hell.redis;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPool;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * cachelock增强类
 * 
 * @author zhengwen
 *
 */
public class CacheLockInterceptor implements MethodInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheLockInterceptor.class);

    private JedisPool jedisPool;

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        LOGGER.debug("进入缓存锁切面");
        Method method = invocation.getMethod();
        CacheLock cacheLock = method.getAnnotation(CacheLock.class);
        // 没加锁注解，直接过
        if (cacheLock == null) {
            return invocation.proceed();
        }
        Object[] args = invocation.getArguments();
        Annotation[][] annotations = method.getParameterAnnotations();
        Object locked = getLockedObject(args, annotations);
        // 暂时只支持对基本数据类型和String类型的锁
        String objectvalue = locked.toString();
        RedisLock redisLock = new RedisLock(cacheLock.lockedPrefix(), objectvalue, jedisPool);
        // 该方法里面会释放redis链接，所以不用担心方法执行时间太长，而导致redis链接耗尽
        boolean result = redisLock.lock(cacheLock.timeOut(), cacheLock.expireTime());
        if (!result) {
            return null;
        }
        try {
            return method.invoke(invocation.getThis(), args);
        } catch (Exception e) {
            // checked exception in current method wrapp by this  wen.zheng
            if (e instanceof InvocationTargetException) {
                InvocationTargetException invocationTargetException = (InvocationTargetException) e;
                Throwable throwable = invocationTargetException.getTargetException();
                throw throwable;
            }
            throw e;

        } finally {
            LOGGER.debug("退出缓存锁切面");
            redisLock.unlock();
        }
    }

    private Object getLockedObject(Object[] args, Annotation[][] annotations) throws CacheLockException {
        if (args == null || args.length == 0) {
            throw new CacheLockException("方法参数为空，不会有能被锁定的对象");
        }
        if (annotations == null || annotations.length == 0) {
            throw new CacheLockException("没有被注解的参数");
        }
        // 目前不支持锁多个参数，只支持锁第一个标记为lockedObject的参数
        int index = -1;
        for (int i = 0; i < annotations.length; i++) {
            for (int j = 0; j < annotations[i].length; j++) {
                if (annotations[i][j] instanceof LockedObject) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                break;
            }
        }
        if (index == -1) {
            throw new CacheLockException("请指定被锁定的参数");
        }
        return args[index];
    }
}

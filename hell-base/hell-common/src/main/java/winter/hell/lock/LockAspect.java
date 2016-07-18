package winter.hell.lock;

import me.ele.elog.Log;
import me.ele.elog.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * Created by Rayee on 16/6/22.
 */
@Component
@Aspect
public class LockAspect {

    private Log logger = LogFactory.getLog(LockAspect.class);

    @Resource
    LockService lockService;

    @Pointcut("(@annotation(me.ele.sargeras.lock.DistributedLock))")
    public void execute() {

    }


    @Around(value = "execute()")
    public Object doLock(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature joinPointObject = (MethodSignature) pjp.getSignature();
        Method method = joinPointObject.getMethod();
        DistributedLock lock = method.getAnnotation(DistributedLock.class);

        if(lock == null){
            pjp.proceed();
        }
        Object proceed;
        LockDto lockDto = buildLock(lock);
        boolean getLock = false;
        try {
            getLock = lockService.lock(lockDto);
            if(!getLock){
                throw new Exception("未获取到锁！");
            }
            proceed = pjp.proceed();
        }catch (Throwable throwable){
            throw throwable;
        }finally {
            if(getLock){
                //只有在获取锁成功时才尝试释放锁，如果获取锁失败
                lockService.release(lock.sysName(), lock.key());
            }
        }
        return proceed;
    }


    private LockDto buildLock(DistributedLock lock){
        LockDto lockDto = new LockDto();
        lockDto.setSysName(lock.sysName());
        lockDto.setKey(lock.key());
        lockDto.setLockTime(lock.lockTime());
        lockDto.setIsDegrade(lock.isDegrade());
        return lockDto;
    }
}

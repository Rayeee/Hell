package winter.hell.lock;

import java.lang.annotation.*;

/**
 * Created by Rayee on 16/6/22.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DistributedLock {

    /* 系统名称 */
    String sysName() default "LOCK_SYS_";

    String key() default "KEY_";

    long lockTime() default 2000L;

    boolean isDegrade() default false;

}

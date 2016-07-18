package winter.hell.redis;

import java.lang.annotation.*;

/**
 * 
 * @author zhengwen
 * 标记方法参数为被锁的对象
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LockedObject {

}

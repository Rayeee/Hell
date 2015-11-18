package winter.hell.exception;

import java.lang.annotation.*;

/**
 * Created by ZGY on 15/11/18.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Desc {
    public String value() default "";
    public String code() default "";
}

package rog.sziit.dynamicplus.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:poboking
 * @version:1.0
 * @time:2023/5/21 20:04
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SwitchDataSource {
    String value() default "";
}

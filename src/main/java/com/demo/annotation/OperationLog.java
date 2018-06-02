package com.demo.annotation;

import java.lang.annotation.*;

/**
 * 日志记录注解
 */
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationLog {

    String description() default "";
}

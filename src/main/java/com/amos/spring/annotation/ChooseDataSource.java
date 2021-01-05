package com.amos.spring.annotation;

import java.lang.annotation.*;

/**
 * 注解式数据源，用来进行数据源切换
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ChooseDataSource {

    String value() default "";
}

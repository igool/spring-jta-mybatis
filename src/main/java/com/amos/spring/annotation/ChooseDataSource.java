package com.amos.spring.annotation;

import java.lang.annotation.*;

/**
 * 注解式数据源，用来进行数据源切换
 * User:Amos.zhou
 * Date: 14-2-27
 * Time: 下午2:34
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ChooseDataSource {

    String value() default "";
}

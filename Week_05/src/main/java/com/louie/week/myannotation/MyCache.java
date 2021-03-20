package com.louie.week.myannotation;

import java.lang.annotation.*;
import java.time.Duration;
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyCache {
    //秒
    int duration() default 5;
}

package com.huawei.com.rdsdemo.config.dynamic;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DS {
    String value();
}

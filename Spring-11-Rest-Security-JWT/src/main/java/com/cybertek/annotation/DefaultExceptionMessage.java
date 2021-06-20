package com.cybertek.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)             //it will be method level. We will add it to controller
@Retention(RetentionPolicy.RUNTIME)     //Will be active only when the app is running
public @interface DefaultExceptionMessage {

    String defaultMessage() default "";  //as default it will be empty
}

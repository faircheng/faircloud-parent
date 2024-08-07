package com.faircloud.platform.common.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 自定义手机号码校验器
 *
 * @author Felix Cheng
 **/
@Target({  FIELD, PARAMETER })
@Retention(RUNTIME)
@Documented
//校验类
@Constraint(validatedBy = { MobileValidator.class })
public @interface Mobile {

    //默认为true
    boolean required() default true;

    //提示信息
    String message() default "{InvalidParameter.Mobile.Format}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

package com.sirzhangs.usercenter.common.validate;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.sirzhangs.usercenter.common.validate.validator.CustomValidator;

@Documented   //打包生成文档
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE }) // 约束注解应用的目标元素类型
@Retention(RUNTIME) // 约束注解应用的时机
@Constraint(validatedBy = {CustomValidator.class}) // 与约束注解关联的验证器
public @interface CustomValidate {

	String message() default " "; // 约束注解验证时的输出消息

	Class<?>[] groups() default {}; // 约束注解在验证时所属的组别

	Class<? extends Payload>[] payload() default {}; // 约束注解的有效负载
}

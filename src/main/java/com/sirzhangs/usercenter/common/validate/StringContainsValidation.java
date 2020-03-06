package com.sirzhangs.usercenter.common.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.sirzhangs.usercenter.common.validate.validator.StringContainsValidater;

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {StringContainsValidater.class})
public @interface StringContainsValidation {
	
	String regex() default "";
	
	String message() default "";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	@Target({ElementType.FIELD,ElementType.METHOD,ElementType.ANNOTATION_TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@interface List{
		StringContainsValidation[] value();
	}
	
}

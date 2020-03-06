package com.sirzhangs.usercenter.common.validate.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sirzhangs.usercenter.common.validate.StringContainsValidation;

public class StringContainsValidater implements ConstraintValidator<StringContainsValidation, String> {

	private String regex;

	@Override
	public void initialize(StringContainsValidation constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
		this.regex=constraintAnnotation.regex();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.startsWith(regex)) {
			return true;
		}
		return false;
	}

}

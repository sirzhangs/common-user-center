 package com.sirzhangs.usercenter.common.validate.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sirzhangs.usercenter.common.validate.CustomValidate;

public class CustomValidator implements ConstraintValidator<CustomValidate,String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		System.out.println("开始进行校验");
		return false;
	}

}

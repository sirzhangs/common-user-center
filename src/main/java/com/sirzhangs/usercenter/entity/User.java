package com.sirzhangs.usercenter.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.sirzhangs.usercenter.common.constant.GeneralRegexPattern;
import com.sirzhangs.usercenter.common.constant.MessageContant;
import com.sirzhangs.usercenter.common.validate.CustomValidate;
import com.sirzhangs.usercenter.common.validate.StringContainsValidation;

import lombok.Data;

@Data
public class User implements Serializable{

	private static final long serialVersionUID = 725061225643702618L;

	@CustomValidate(message = "测试自定义校验器")
	private String id;

	@NotNull
	private String loginAccount;

	@Length(min = 6,max = 16,message = "请输入6到12位字符")
	private String userPassword;
	
	private String userName;
	
	@Pattern(regexp = GeneralRegexPattern.DOMESTIC_CELL_PHONE_NUMER,message = MessageContant.PHONE_FORMAT_ERROR)
	private String telephone;

	@StringContainsValidation.List({
		@StringContainsValidation(regex = "@",message = "没有@标识符"),
		@StringContainsValidation(regex = ".com",message = "没有.com标识符")
	})
	private String email;

	private Integer authStatus;

	private Integer userType;

	private String realName;

	private String cardNum;

	private Integer accountType;

}

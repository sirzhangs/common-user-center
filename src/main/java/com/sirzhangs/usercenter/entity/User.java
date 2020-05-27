package com.sirzhangs.usercenter.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.sirzhangs.usercenter.common.constant.GeneralRegexPattern;
import com.sirzhangs.usercenter.common.constant.MessageContant;

import lombok.Data;

@Data
public class User implements Serializable{

	private static final long serialVersionUID = 725061225643702618L;

	/**
	 * 	用户id主键
	 */
//	@CustomValidate(message = "测试自定义校验器")
	private String id;

	/**
	 * 	用户账号
	 */
//	@NotNull
	private String userAccount;

	/*
	 * 	用户密码
	 */
	@Length(min = 6,max = 16,message = "请输入6到12位字符")
	private String userPassword;
	
	/**
	 * 	用户名称
	 */
	private String userName;
	
	/**
	 * 	联系电话
	 */
	@Pattern(regexp = GeneralRegexPattern.DOMESTIC_CELL_PHONE_NUMER,message = MessageContant.PHONE_FORMAT_ERROR)
	private String telephone;

	/**
	 * 	用户email
	 */
	/*
	 * @StringContainsValidation.List({
	 * 
	 * @StringContainsValidation(regex = "@",message = "没有@标识符"),
	 * 
	 * @StringContainsValidation(regex = ".com",message = "没有.com标识符") })
	 */
	private String email;

	/**
	 *	创建时间
	 */
	private Date createTime;
	
	/**
	 * 	创建人
	 */
	private String creator;
	
	/**
	 * 	创建人ID
	 */
	private String creatorId;

}

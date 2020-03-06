package com.sirzhangs.usercenter.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class User implements Serializable{

	private static final long serialVersionUID = 725061225643702618L;

	private String id;

	@NotNull
	private String loginAccount;

	private String userPassword;

	private String userName;
	
	private String telephone;

	private String email;

	private Integer authStatus;

	private Integer userType;

	private String realName;

	private String cardNum;

	private Integer accountType;

}

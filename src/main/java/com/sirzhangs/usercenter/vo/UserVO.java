package com.sirzhangs.usercenter.vo;

import java.io.Serializable;

import com.sirzhangs.usercenter.entity.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserVO extends User implements Serializable{
	
	private static final long serialVersionUID = -3376374028505989614L;

	private String code;

	private String token;
	
}

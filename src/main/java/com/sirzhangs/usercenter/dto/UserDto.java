package com.sirzhangs.usercenter.dto;

import com.sirzhangs.common.entity.PageConfigure;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserDto extends PageConfigure{
	
	private Integer userType;
	
	private Integer authStatus;

}

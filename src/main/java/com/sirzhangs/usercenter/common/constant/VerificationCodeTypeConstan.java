package com.sirzhangs.usercenter.common.constant;

public enum VerificationCodeTypeConstan {

	ONCE_CODE(100,"一次性验证码，用完后过期"),
	
	EXPIRE_CODE(200,"过期验证码，时间期限内重复可用"),
	
	ONCE_EXPIRE_CODE(300,"一次性过期验证码")
	;
	
	
	private Integer code;
	
	private String descripts;

	private VerificationCodeTypeConstan(Integer code,String descripts) {
		this.code = code;
		this.descripts =descripts; 
	}

	public Integer getCode() {
		return code;
	}

	public String getDescripts() {
		return descripts;
	}
	
}

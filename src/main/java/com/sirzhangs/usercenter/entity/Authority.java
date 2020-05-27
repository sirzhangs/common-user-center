package com.sirzhangs.usercenter.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 	权限
 * @author sirzh
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Authority extends DataBaseBase implements Serializable{

	/**
	 * 	序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 	主键id
	 */
	private int id;
	
	/**
	 * 	权限编码
	 */
	private String authCode;
	
	/**
	 * 	权限名称
	 */
	private String authName;
}

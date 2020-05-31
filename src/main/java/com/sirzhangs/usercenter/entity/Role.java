package com.sirzhangs.usercenter.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 	角色表
 * @author sirzh
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends DataBase implements Serializable{

	/**
	 * 	序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 	主键id
	 */
	private int id;
	
	/**
	 *	编号
	 */
	private String roleCode;
	
	/**
	 * 	角色名称
	 */
	private String roleName;
}

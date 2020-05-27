package com.sirzhangs.usercenter.entity;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 	字典表
 * @author sirzh
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Dictionary extends DataBaseBase implements Serializable{

	/**
	 * 	序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 	主键ID
	 */
	private int id;
	
	/**
	 * 	编码
	 */
	@NotEmpty(message = "编码不能为空")
	private String code;
	
	/**
	 * 	父编码
	 */
	private String parentCode;
	
	/**
	 * 	键
	 */
	@NotEmpty(message = "label不能为空")
	private String label;
	
	/**
	 * 	值
	 */
	@NotEmpty(message = "值不能为空")
	private String value;
}

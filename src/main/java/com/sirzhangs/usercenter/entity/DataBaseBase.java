package com.sirzhangs.usercenter.entity;

import java.util.Date;

import lombok.Data;

/**
 * 	数据库公共字段
 * @author sirzh
 *
 */
@Data
public class DataBaseBase {

	/**
	 * 	创建时间
	 */
	private Date createTime;
	
	/**
	 * 	创建人名称
	 */
	private String creator;
	
	/**
	 * 	创建人ID
	 */
	private String creatorId;
}

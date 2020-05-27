package com.sirzhangs.usercenter.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Menu {

	/**
	 * 主键id
	 */
	private int id;
	
	/**
	 * 菜单编号
	 */
	private String menuCode;
	
	/**
	 * 菜单名称
	 */
	private String menuName;
	
	/**
	 * 父菜单
	 */
	private String parentCode;
	
	/**
	 * 菜单地址
	 */
	private String menuUrl;
	
	/**
	 * 路由地址
	 */
	private String menuRouter;
	
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GTM+8")
	private Date createTime;
	
	/**
	 * 创建人
	 */
	private String creator;
	
	/**
	 * 创建人ID
	 */
	private String creatorId;
}

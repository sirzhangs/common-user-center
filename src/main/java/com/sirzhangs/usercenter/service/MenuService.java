package com.sirzhangs.usercenter.service;

import java.util.List;

import com.sirzhangs.usercenter.entity.Menu;
import com.sirzhangs.usercenter.vo.MenuVO;

public interface MenuService {

	/**
	 * 头部菜单
	 * @return
	 */
	List<Menu> getHeaderMenu();

	/**
	 * 左侧菜单
	 * @return
	 */
	List<MenuVO> getLeftMenu();
	
	/**
	 * 新增菜单
	 * @param menu
	 */
	int insert(Menu menu);

}

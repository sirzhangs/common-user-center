package com.sirzhangs.usercenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirzhangs.usercenter.entity.Menu;
import com.sirzhangs.usercenter.mapper.MenuMapper;
import com.sirzhangs.usercenter.service.MenuService;
import com.sirzhangs.usercenter.vo.MenuVO;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<Menu> getHeaderMenu() {
		return null;
	}

	@Override
	public List<MenuVO> getLeftMenu() {
		List<MenuVO> leftMenus = menuMapper.getLeftMenu();
		return leftMenus; 
	}

	@Override
	public int insert(Menu menu) {
		return menuMapper.insert(menu);
	}

}

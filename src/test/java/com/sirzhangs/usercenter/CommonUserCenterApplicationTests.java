package com.sirzhangs.usercenter;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sirzhangs.common.util.GeneratorCodeUtil;
import com.sirzhangs.usercenter.entity.Menu;
import com.sirzhangs.usercenter.mapper.MenuMapper;

@SpringBootTest
class CommonUserCenterApplicationTests {
	
	@Autowired
	private MenuMapper menuMapper;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void insertMenu() {
		Menu menu = new Menu();
		menu.setMenuCode(GeneratorCodeUtil.generatorCode(16));
		menu.setMenuName("菜单");
		menu.setMenuUrl("/home");
		menuMapper.insert(menu);
	}
	
	@Test
	public void insertBatchMenu() {
		List<Menu> menus = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			Menu menu = new Menu();
			menu.setMenuCode(GeneratorCodeUtil.generatorCode(16));
			menu.setMenuName("菜单"+i);
			menu.setMenuUrl("/home");
			menus.add(menu);
		}
		menuMapper.insertBatch(menus);
	}

}

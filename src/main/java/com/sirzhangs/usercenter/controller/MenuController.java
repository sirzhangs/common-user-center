package com.sirzhangs.usercenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sirzhangs.usercenter.entity.Menu;
import com.sirzhangs.usercenter.service.MenuService;
import com.sirzhangs.usercenter.vo.MenuVO;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@PostMapping("getHeaderMenu")
	public String getHeaderMenu(Model model) {
		List<Menu> menuList = menuService.getHeaderMenu();
		model.addAttribute("menus", menuList);
		return "commons/commons :: commonMenu";
	}
	
	@PostMapping("getLeftMenu")
	public String getLeftMenu(Model model) {
		List<MenuVO> menuList = menuService.getLeftMenu();
		model.addAttribute("menus", menuList);
		return "commons/commons::commonMenu";
	}
}

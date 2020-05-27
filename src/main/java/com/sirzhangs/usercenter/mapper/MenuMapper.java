package com.sirzhangs.usercenter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sirzhangs.usercenter.entity.Menu;
import com.sirzhangs.usercenter.vo.MenuVO;

@Mapper
public interface MenuMapper {

	@Insert("INSERT INTO uc_menu(menu_code,menu_name,parent_code,menu_url) "
			+ "VALUES(#{menuCode},#{menuName},#{parentCode},#{menuUrl})")
	int insert(Menu menu);
	
	@Insert("<script>"
			+ " INSERT INTO uc_menu(menu_code,menu_name,parent_code,menu_url) "
			+ " VALUES "
			+ " <foreach collection='menus' item='menu' separator=',' >"
			+ " (#{menu.menuCode},#{menu.menuName},#{menu.parentCode},#{menu.menuUrl})"
			+ " </foreach>"
			+ "</script>")
	int insertBatch(@Param("menus")List<Menu> menus);
	
	@Select("SELECT menu_code,menu_name,parent_code,menu_url FROM uc_menu WHERE menu_code in (SELECT parent_code FROM uc_menu)")
	@Results({
			@Result(property = "menuCode",column = "menu_code"),
			@Result(property = "children",column = "menu_code", many = @Many(select = "com.sirzhangs.usercenter.mapper.MenuMapper.getChildren"))
	})
	List<MenuVO> getLeftMenu();
	
	@Select("SELECT menu_code,menu_name,parent_code,menu_url FROM uc_menu WHERE parent_code=#{menuCode}")
	List<Menu> getChildren(String menuCode); 
	
}

package com.sirzhangs.usercenter.vo;

import java.util.ArrayList;
import java.util.List;

import com.sirzhangs.usercenter.entity.Menu;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MenuVO extends Menu{

	private List<MenuVO> children = new ArrayList<>();
	
}

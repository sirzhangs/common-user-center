package com.sirzhangs.usercenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sirzhangs.common.entity.RequestResult;
import com.sirzhangs.usercenter.entity.User;
import com.sirzhangs.usercenter.service.UserService;
import com.sirzhangs.usercenter.vo.UserVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "UserController",description = "用户功能")
@Controller
@RequestMapping(value="/user/manage/",produces= {"application/json;charset=UTF-8","application/x-www-form-urlencoded;charset=UTF-8"})
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "注册",notes="")
//	@ApiImplicitParam(name = "userVo", value = "用户userVo", required = true, dataType = "UserVo")
	@PostMapping("registered")
	public String registered(
			UserVO userVo
			) {
		RequestResult result = userService.register(userVo);
		
		if(result.getCode() == 200) {
			System.out.println("cs");
			return "redirect:/goHome";
		}
		return "redirect:/register";
	}
	
	@ApiOperation(value = "登录",notes="")
	@PostMapping("signIn")
	public String signIn(
			User user
			) {
		RequestResult result = userService.signIn(user);
		
		if(result.getCode() == 200) {
			return "redirect:/home";
		}
		
		return "redirect:/error";
	}
	
	@ApiOperation(value = "退出",notes="")
	@PostMapping("signOut")
	public String signOut(
			UserVO userVo
			) {
		RequestResult result = userService.signOut(userVo);
		if(result.getCode() == 200) {
			return "redirect:/login";
		}
		
		return "redirect:/error";
	}
	
	@ApiOperation(value = "刷新",notes="")
	@PostMapping("refreshToken")
	@ResponseBody
	public RequestResult refreshToken() {
		return userService.refreshToken();
	}
	
	@ApiOperation(value = "发送验证码",notes="")
	@GetMapping(value="sendCode")
	@ResponseBody
	public RequestResult sendCode(
			@RequestParam(value = "telephone",required = true) String telephone,
			@RequestParam(value = "type",required = true)Integer type
			) {
		return userService.sendCode(telephone, type);
	}
}

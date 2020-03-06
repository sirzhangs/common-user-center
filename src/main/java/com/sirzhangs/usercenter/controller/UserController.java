package com.sirzhangs.usercenter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirzhangs.common.entity.RequestResult;
import com.sirzhangs.usercenter.entity.User;
import com.sirzhangs.usercenter.service.UserService;
import com.sirzhangs.usercenter.vo.UserVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value = "UserController",description = "用户功能")
@RestController
@RequestMapping(value="/user/manage/",produces= "application/json;charset=UTF-8")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "注册",notes="")
	@ApiImplicitParam(name = "userVo", value = "用户userVo", required = true, dataType = "UserVo")
	@PostMapping("register")
	public RequestResult register(
			@RequestBody @Valid UserVo userVo
			) {
		return userService.register(userVo);
	}
	
	@ApiOperation(value = "登录",notes="")
	@PostMapping("signIn")
	public RequestResult signIn(
			@RequestBody User user
			) {
		return userService.signIn(user);
	}
	
	@ApiOperation(value = "退出",notes="")
	@PostMapping("signOut")
	public RequestResult signOut(
			@RequestBody UserVo userVo
			) {
		return userService.signOut(userVo);
	}
	
	@ApiOperation(value = "刷新",notes="")
	@PostMapping("refreshToken")
	public RequestResult refreshToken() {
		return userService.refreshToken();
	}
	
	@ApiOperation(value = "发送验证码",notes="")
	@GetMapping(value="sendCode/{telephone}/{type}")
	public RequestResult sendCode(
			@PathVariable(value = "telephone") String telephone,
			@PathVariable(value = "type")Integer type
			) {
		return userService.sendCode(telephone, type);
	}
}

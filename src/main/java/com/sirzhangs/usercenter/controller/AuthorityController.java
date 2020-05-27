package com.sirzhangs.usercenter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirzhangs.common.entity.RequestResult;
import com.sirzhangs.usercenter.dto.AuthorityDto;
import com.sirzhangs.usercenter.entity.Authority;
import com.sirzhangs.usercenter.service.AuthorityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/auth")
public class AuthorityController {

	@Autowired
	private AuthorityService authorityService;
	
	@ApiOperation(value = "addAuth")
	@PostMapping("addAuth")
	public RequestResult addAuth(
			@Valid Authority authority
			) {
		return authorityService.addAuth(authority);
	}
	
	@ApiOperation(value = "deleteAuth")
	@PostMapping("deleteAuth")
	public RequestResult deleteAuth(
			String id) {
		return authorityService.deleteAuth(id);
	}
	
	@ApiOperation(value = "updateAuth")
	@PostMapping("updateAuth")
	public RequestResult updateAuth(
			@Valid Authority authority
			) {
		return authorityService.upateAuth(authority);
	}
	
	@ApiOperation(value = "findList")
	@PostMapping("findList")
	public RequestResult findList(
			@Valid AuthorityDto authorityDto
			) {
		return authorityService.findList(authorityDto);
	}
	
}

package com.sirzhangs.usercenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sirzhangs.common.entity.RequestResult;
import com.sirzhangs.usercenter.dto.AuthorityDto;
import com.sirzhangs.usercenter.entity.Authority;
import com.sirzhangs.usercenter.mapper.AuthorityMapper;
import com.sirzhangs.usercenter.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityMapper authorityMapper;
	
	@Override
	public RequestResult addAuth(Authority authority) {
		int count = authorityMapper.insertAuth(authority);
		return count > 0 ? RequestResult.ok() : RequestResult.fail();
	}

	@Override
	public RequestResult deleteAuth(String id) {
		int count = authorityMapper.deleteAuth(id);
		return count > 0 ? RequestResult.ok() : RequestResult.fail();
	}

	@Override
	public RequestResult upateAuth(Authority authority) {
		int count = authorityMapper.upateAuth(authority);
		return count > 0 ? RequestResult.ok() : RequestResult.fail();
	}

	@Override
	public RequestResult findList(AuthorityDto authorityDto) {
		PageHelper.startPage(authorityDto.getPageNum(),authorityDto.getPageSize());
		
		List<Authority> list = authorityMapper.findList(authorityDto);
		
		PageInfo<Authority> pageInfo = new PageInfo<>(list);
		
		return RequestResult.ok("查询成功", pageInfo.getList(), pageInfo.getTotal());
	}

}

package com.sirzhangs.usercenter.service;

import com.sirzhangs.common.entity.RequestResult;
import com.sirzhangs.usercenter.dto.AuthorityDto;
import com.sirzhangs.usercenter.entity.Authority;

public interface AuthorityService {

	/**
	 * 	新增
	 * @param authority
	 * @return
	 */
	RequestResult addAuth(Authority authority);

	/**
	 * 	删除
	 * @param id
	 * @return
	 */
	RequestResult deleteAuth(String id);

	/**
	 * 	修改
	 * @return
	 */
	RequestResult upateAuth(Authority authority);

	/**
	 * 	查询
	 * @param authorityDto
	 * @return
	 */
	RequestResult findList(AuthorityDto authorityDto);

}

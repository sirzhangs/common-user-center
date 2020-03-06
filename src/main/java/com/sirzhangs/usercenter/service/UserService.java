package com.sirzhangs.usercenter.service;

import com.sirzhangs.common.entity.RequestResult;
import com.sirzhangs.usercenter.entity.User;
import com.sirzhangs.usercenter.vo.UserVo;

public interface UserService {

	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	RequestResult register(UserVo userVo);
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	RequestResult signIn(User user);
	
	/**
	 * 退出登录
	 * @param user
	 * @return
	 */
	RequestResult signOut(UserVo userVo);
	
	/**
	 * 刷新token
	 * @return
	 */
	RequestResult refreshToken();
	
	/**
	 * 发送验证码
	 * @return
	 */
	RequestResult sendCode(String telephone,Integer type);
}

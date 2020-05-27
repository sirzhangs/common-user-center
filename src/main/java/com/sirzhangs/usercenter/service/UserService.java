package com.sirzhangs.usercenter.service;

import com.sirzhangs.common.entity.RequestResult;
import com.sirzhangs.usercenter.entity.User;
import com.sirzhangs.usercenter.vo.UserVO;

public interface UserService {

	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	RequestResult register(UserVO userVo);
	
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
	RequestResult signOut(UserVO userVo);
	
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

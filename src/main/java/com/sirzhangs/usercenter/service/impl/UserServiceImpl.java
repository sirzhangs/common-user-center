package com.sirzhangs.usercenter.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sirzhangs.common.entity.RequestResult;
import com.sirzhangs.common.util.GeneratorCodeUtil;
import com.sirzhangs.common.util.MD5Util;
import com.sirzhangs.common.util.RedisUtil;
import com.sirzhangs.usercenter.common.constant.GeneralRegexPattern;
import com.sirzhangs.usercenter.common.constant.MessageContant;
import com.sirzhangs.usercenter.common.constant.VerificationCodeTypeConstan;
import com.sirzhangs.usercenter.entity.User;
import com.sirzhangs.usercenter.mapper.UserMapper;
import com.sirzhangs.usercenter.service.UserService;
import com.sirzhangs.usercenter.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	private static final String CHECK_CODE = "usercenter:check:code:";

	private static final String TOKEN_CODE = "usercenter:token:code:";

	private static final long BASE_NUMBER = 60 * 1000L;

	@Autowired
	private RedisUtil redisUtil;

	@Autowired
	private UserMapper userMapper;

	@Override
	public RequestResult register(UserVO userVo) {
		String keys = CHECK_CODE + userVo.getTelephone();
		boolean flag = redisUtil.isExsistKeyAndValue(keys, userVo.getCode());
		if (!flag) {
			return RequestResult.fail(MessageContant.CHECK_ERROR);
		}
		redisUtil.removeKey(keys);
		// 注册成功应该包含跳转登录页，或者直接登录返回其token
		// TODO
		User user = new User();
		BeanUtils.copyProperties(userVo, user);
		user.setId(GeneratorCodeUtil.generatorCode(32));
		user.setUserAccount(GeneratorCodeUtil.generatorCode(8));
		Integer count = userMapper.add(user);
		return count > 0 ? RequestResult.ok(MessageContant.REGISTER_SUCCESS)
				: RequestResult.fail(MessageContant.REGISTER_FAIL);
	}

	@Override
	public RequestResult signIn(User user) {

		String newToken = null;

		String token = redisUtil.getValueForString(TOKEN_CODE + user.getUserAccount());
		if (!StringUtils.isEmpty(token)) {
			return RequestResult.ok(MessageContant.SIGNIN_SUCCESS, token);
		}
		try {
			newToken = MD5Util.md5(user.getUserAccount() + user.getUserPassword());
		} catch (Exception e) {
			return RequestResult.fail();
		}

		if (newToken.isEmpty()) {
			return RequestResult.fail();
		}
		boolean flag = redisUtil.setExpireValue(TOKEN_CODE + user.getUserAccount(), newToken, 15 * 60 * 60 * 1000L);
		return flag ? RequestResult.ok(MessageContant.SIGNIN_SUCCESS, newToken)
				: RequestResult.fail(MessageContant.SIGNIN_FAIL);
	}

	@Override
	public RequestResult signOut(UserVO userVo) {
		boolean flag = false;

		// 查询token
		String token = redisUtil.getValueForString(TOKEN_CODE + userVo.getUserAccount());
		// 验证token是否正确
		if (!StringUtils.isEmpty(token) && token.equals(userVo.getToken())) {
			flag = redisUtil.removeKey(userVo.getUserAccount());
		}

		return flag ? RequestResult.ok(MessageContant.SIGNOUT_SUCCESS)
				: RequestResult.fail(MessageContant.SIGNOUT_FAIL);
	}

	@Override
	public RequestResult refreshToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestResult sendCode(String telephone, Integer type) {
		if (StringUtils.isEmpty(telephone) || type == null) {
			return RequestResult.checkFail();
		}
		Pattern pattern = Pattern.compile(GeneralRegexPattern.DOMESTIC_CELL_PHONE_NUMER);
		Matcher matcher = pattern.matcher(telephone);
		if(!matcher.matches()) {
			return RequestResult.checkFail(MessageContant.PHONE_FORMAT_ERROR);
		}
		// 目前只能模拟发送验证码
		String key = CHECK_CODE + telephone;
		String code = GeneratorCodeUtil.generatorCode(6);

		boolean flag = false;
		if (type.equals(VerificationCodeTypeConstan.EXPIRE_CODE.getCode())
				|| type.equals(VerificationCodeTypeConstan.ONCE_EXPIRE_CODE.getCode())) {
			flag = redisUtil.setExpireValue(key, code, 10 * BASE_NUMBER);
		} else if (type.equals(VerificationCodeTypeConstan.ONCE_CODE.getCode())) {
			flag = redisUtil.setValue(key, code);
		} else {
			flag = redisUtil.setDefaultExpireKey(key, code);
		}

		return flag ? RequestResult.ok(MessageContant.SEND_CODE_SUCCESS, code)
				: RequestResult.fail(MessageContant.SEND_CODE_FAIL);
	}

	public RequestResult checkCode(String telephone, String code) {
		if (StringUtils.isEmpty(telephone) || code.isEmpty()) {
			return RequestResult.checkFail();
		}
		boolean flag = redisUtil.isExsistKeyAndValue(telephone, code);
		return flag ? RequestResult.ok(MessageContant.CHECK_CODE_SUCCESS)
				: RequestResult.ok(MessageContant.CHECK_CODE_FAIL);
	}

}

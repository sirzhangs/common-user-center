package com.sirzhangs.usercenter.service;

import com.sirzhangs.common.entity.RequestResult;
import com.sirzhangs.usercenter.entity.Dictionary;

/**
 * 	字典业务
 * @author sirzh
 *
 */
public interface DictionaryService {
	
	/**
	 * 	添加字典
	 * @param dictionary
	 * @return
	 */
	RequestResult addDic(Dictionary dictionary);
	
	/**
	 * 	删除字典
	 * @param code
	 * @return
	 */
	RequestResult deleteDic(String code);
	
	/**
	 * 	修改字典
	 * @param dictionary
	 * @return
	 */
	RequestResult updateDic(Dictionary dictionary);

	/**
	 * 	根据编码获取字典信息
	 * @param code
	 * @return
	 */
	RequestResult findDicByCode(String code);
	
}

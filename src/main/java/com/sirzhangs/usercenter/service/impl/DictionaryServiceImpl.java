package com.sirzhangs.usercenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirzhangs.common.entity.RequestResult;
import com.sirzhangs.common.util.ConnectionUtils;
import com.sirzhangs.usercenter.entity.Dictionary;
import com.sirzhangs.usercenter.mapper.DictionaryMapper;
import com.sirzhangs.usercenter.service.DictionaryService;

@Service
public class DictionaryServiceImpl implements DictionaryService{
	
	@Autowired
	private DictionaryMapper dictionaryMapper;

	@Override
	public RequestResult addDic(Dictionary dictionary) {
		int count = dictionaryMapper.insertDic(dictionary);
		return count > 0 ? RequestResult.ok() : RequestResult.fail();
	}
	
	@Override
	public RequestResult deleteDic(String code) {
		int count = dictionaryMapper.deleteDic(code);
		return count > 0 ? RequestResult.ok() : RequestResult.fail();
	}
	

	@Override
	public RequestResult updateDic(Dictionary dictionary) {
		int count = dictionaryMapper.updateDic(dictionary);
		return count > 0 ? RequestResult.ok() : RequestResult.fail();
	}
	
	@Override
	public RequestResult findDicByCode(String code) {
		List<Dictionary> dictionaryList = dictionaryMapper.findDicByCode(code);
		return ConnectionUtils.isEmpty(dictionaryList) ? RequestResult.fail("没有找到相关数据"):RequestResult.ok(dictionaryList);
	}

}

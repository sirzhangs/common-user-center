package com.sirzhangs.usercenter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirzhangs.common.entity.RequestResult;
import com.sirzhangs.usercenter.entity.Dictionary;
import com.sirzhangs.usercenter.service.DictionaryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 	字典
 * @author sirzh
 *
 */
@Api
@RestController
@RequestMapping("/dic")
public class DictionaryController {

	@Autowired
	private DictionaryService dictionaryService;
	
	@ApiOperation(value = "addDic")
	@PostMapping("addDic")
	public RequestResult addDic(
			@Valid Dictionary dictionary
			) {
		return dictionaryService.addDic(dictionary);
	}
	
	@ApiOperation(value = "deleteDic")
	@PostMapping("deleteDic")
	public RequestResult deleteDic(
			String code
			){
		return dictionaryService.deleteDic(code);
	}
	
	@ApiOperation(value = "udpateDic")
	@PostMapping("udpateDic")
	public RequestResult udpateDic(
			@Valid Dictionary dictionary) {
		return dictionaryService.updateDic(dictionary);
	}
	
	@ApiOperation(value = "findDicByCode")
	@GetMapping("/findDicByCode/{code}")
	public RequestResult findDicByCode(
			@PathVariable String code) {
		if(StringUtils.isEmpty(code)) {
			return RequestResult.checkFail();
		}
		return dictionaryService.findDicByCode(code);
	}
}

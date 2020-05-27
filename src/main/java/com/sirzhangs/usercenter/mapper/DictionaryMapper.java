package com.sirzhangs.usercenter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sirzhangs.usercenter.entity.Dictionary;

public interface DictionaryMapper {
	
	@Insert("INSERT INTO uc_dictionary('code','parent_code','label','value','creator','creator_id')"
			+ " VALUES(#{code},#{parentCode},#{label},#{value},#{creator},#{creatorId})")
	int insertDic(Dictionary dictionary);
	
	@Delete("DELETE FROM uc_dictionary WHERE code='#{code}'")
	int deleteDic(String code);
	
	@Update("<script>"
			+ " UPDATE uc_dictionary "
			+ " <set>"
			+ "   <if test='label != null'> label = #{label},</if>"
			+ "   <if test='value != null'> value = #{value},</if>"
			+ " </set>"
			+ " WHERE id = #{id}"
			+ "</script>")
	int updateDic(Dictionary dictionary);

	@Select("SELECT key,value FROM uc_dictionary WHERE parent_code = #{code}")
	List<Dictionary> findDicByCode(String code);


	
}

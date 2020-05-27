package com.sirzhangs.usercenter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sirzhangs.usercenter.dto.AuthorityDto;
import com.sirzhangs.usercenter.entity.Authority;

@Mapper
public interface AuthorityMapper {

	@Insert("INSERT INTO uc_auth('auth_code','auth_name')"
			+ "VALUES(#{authCode},#{authName})")
	int insertAuth(Authority authority);

	@Delete("DELETE FROM uc_auth WHERE id = #{id}")
	int deleteAuth(String id);
	
	@Update("<script>"
			+ " UPDATE uc_auth "
			+ " <set>"
			+ "		<if test='authName != null'> auth_name = #{authName}</if>"
			+ " </set>"
			+ " WHERE id = #{id}"
			+ "</script>")
	int upateAuth(Authority authority);

	@Select("SELECT id,auth_code,auth_name,create_time FROM uc_auth ORDER BY create_time")
	List<Authority> findList(AuthorityDto authorityDto);

}

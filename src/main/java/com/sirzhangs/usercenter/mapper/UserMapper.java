package com.sirzhangs.usercenter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sirzhangs.usercenter.dto.UserDto;
import com.sirzhangs.usercenter.entity.User;

@Mapper
public interface UserMapper {
	
	Integer add(User user);
	
	Integer delete(List<String> ids);
	
	User findById(String id);
	
	List<User> findList(UserDto userDto);
}

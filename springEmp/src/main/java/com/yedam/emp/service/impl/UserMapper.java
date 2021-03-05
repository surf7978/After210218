package com.yedam.emp.service.impl;

import java.util.List;

import com.yedam.emp.UserVO;

public interface UserMapper {
	public int insertUser(UserVO vo);
	public int deleteUser(UserVO vo);
	public int updateUser(UserVO vo);
	public UserVO getUser(UserVO vo);
	public List<UserVO> getSearchUser(UserVO vo);
}

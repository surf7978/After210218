package com.yedam.emp.service;

import java.util.List;

import com.yedam.emp.UserVO;

public interface UserService {
	int insertUser(UserVO vo);
	int deleteUser(UserVO vo);
	int updateUser(UserVO vo);
	UserVO getUser(UserVO vo);
	List<UserVO> getSearchUser(UserVO vo);
	
	//login계열 여따 넣음
	boolean loginCheck(UserVO vo);
	int updatePW(UserVO vo);
}

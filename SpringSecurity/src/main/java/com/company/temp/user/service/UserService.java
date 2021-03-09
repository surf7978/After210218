package com.company.temp.user.service;

import java.util.List;

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

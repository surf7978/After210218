package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.service.UserService;
import com.yedam.emp.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired UserMapper dao;
	
	public int insertUser(UserVO vo) {
		return dao.insertUser(vo);
	}

	public int deleteUser(UserVO vo) {
		return dao.deleteUser(vo);
	}
	
	public int updateUser(UserVO vo) {
		return dao.updateUser(vo);
	}

	public UserVO getUser(UserVO vo) {
		return dao.getUser(vo);
	}

	public List<UserVO> getSearchUser(UserVO vo) {
		return dao.getSearchUser(vo);
	}

	
	
	public boolean loginCheck(UserVO vo) {
		//단건조회
		UserVO uservo = dao.getUser(vo);
		//id일치하는지 체크
		if(uservo == null) {
			return false;
		}
		//pw일치여부 체크
		if(uservo.getPassword().equals(vo.getPassword())) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int updatePW(UserVO vo) {
		//단건조회
		UserVO uservo = dao.getUser(vo);
		//기존패스워드와 일치하는지 체크
		if(uservo.getPassword().equals(vo.getOldPassword())) {
			return dao.updateUser(vo);
		}else {
			return 0;
		}
	}
}

package com.company.temp.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.company.temp.user.service.UserService;
import com.company.temp.user.service.UserVO;

@Service("userService") //다른곳에 사용할때 이 명칭 써줘야함 
public class UserServiceImpl implements UserService, UserDetailsService {
	
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

	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("---------userService 실행---------");
		UserVO uservo = new UserVO();
		uservo.setId(username);
		uservo = dao.getUser(uservo);
		if(uservo == null) {
			throw new UsernameNotFoundException("NO USER!!!");
		}
		return uservo;
	}
}

package com.yedam.emp.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;

@RestController
public class UserController2 {
	
	@Autowired UserService userService;
	
	//등록처리
	@PostMapping("/insertuser")
	//public UserVO insertUserProc(UserVO vo) {
	public ResponseEntity<Object> insertUserProc(UserVO vo) throws JsonProcessingException {
		userService.insertUser(vo);
		//return userService.getUser(vo);
		
		
		//바로 body 안에 값 넣어버리기 + 위에는 에러나든 안나든 다 200떠서 걍 실행됨 
		UserVO userVO = userService.getUser(vo);
		if(userVO != null) {
			ObjectMapper mapper = new ObjectMapper();
			return ResponseEntity.status(200).body(mapper.writeValueAsString(userVO));
		} else {
			return ResponseEntity.status(500).body("insert 에러");
		}
	}
	//삭제처리
	@GetMapping("/deleteuser")
	public Map<String, Integer> deleteUserProc(UserVO vo){
		int r = userService.deleteUser(vo);
		return Collections.singletonMap("cnt",r);
	}
	//수정처리
	@PostMapping("/updateuser")
	public UserVO updateUserProc(UserVO vo) {
		userService.updateUser(vo);
		return userService.getUser(vo);
	}
	//전체조회
	@GetMapping("/getuserlist")
	public List<UserVO> getSearchUser(UserVO vo) {
		return userService.getSearchUser(vo);
	}
	//단건조회
	@GetMapping("/getuser")
	public UserVO getUser(UserVO vo) {
		return userService.getUser(vo);
	}
}

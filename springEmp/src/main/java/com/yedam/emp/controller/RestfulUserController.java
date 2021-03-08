package com.yedam.emp.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;

@RestController
public class RestfulUserController {
	
	@Autowired UserService userService;
	
	//등록처리
	@PostMapping("/user")
	public UserVO insertUserProc(@RequestBody UserVO vo) {
		userService.insertUser(vo);
		return userService.getUser(vo);
	}
	//삭제처리
	@DeleteMapping(value = "/user/{id}")
	public Map<String, Integer> deleteUserProc(UserVO vo, @PathVariable String id){
		vo.setId(id);
		int r = userService.deleteUser(vo);
		return Collections.singletonMap("cnt",r);
	}
	//수정처리
	@PutMapping("/user")
	public UserVO updateUserProc(@RequestBody UserVO vo) {
		userService.updateUser(vo);
		return userService.getUser(vo);
	}
	//전체조회
	@GetMapping("/user")
	public List<UserVO> getSearchUser(UserVO vo) {
		return userService.getSearchUser(vo);
	}
	//단건조회
	@GetMapping("/user/{id}")
	public UserVO getUser(UserVO vo, @PathVariable String id) {
		vo.setId(id);
		return userService.getUser(vo);
	}
}

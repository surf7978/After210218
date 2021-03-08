package com.yedam.emp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;

@Controller
public class LoginController {
	
	@Resource // = @Autowired
	UserService userService;
	
	@GetMapping("/login") //로그인페이지 이동
	public String login() {
		return "user/login";
	}
	@PostMapping("/login") //로그인 처리
	public String loginProc(UserVO vo, HttpSession session){
		if(userService.loginCheck(vo)) { //로그인 된 경우
			//세션에 저장
			session.setAttribute("loginid", vo.getId());
			return "redirect:/";
		}else { //로그인 틀린 경우
			return "user/login";
		}
	}
	
	
	@GetMapping("/logout") //로그아웃 처리
	public String logoutProc(HttpSession session) {
		session.invalidate(); //세션 무효화
		return "redirect:/";
	}
	
	@GetMapping("/changePW") //패스워드 변경 페이지
	public String changePW() {
		return "user/changePW";
	}
	@PostMapping("changePW") //패스워드 변경 처리
	public String changePWProc(@Valid UserVO vo, HttpSession session){
		//validation 일치여부확인
		
		//패스워드변경서비스
		String id = (String) session.getAttribute("loginid");
		vo.setId(id);
		userService.updatePW(vo);
		return "redirect:/";
	}
}

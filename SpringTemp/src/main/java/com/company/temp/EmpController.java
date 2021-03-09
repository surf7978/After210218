package com.company.temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired EmpService empService;
	
	@RequestMapping("/") //이건 다른컨트롤러 만들어도 하나만 적어줘야함 =유니크 속성
	public String main() {
		return "home";
	}
	
	@GetMapping("/insertEmp") //등록페이지로 이동
	public String insertEmp(EmpVO empVO, Model model) {
		return "/temp/insertEmp";
	}
	
	@PostMapping("/insertEmp") //등록처리
	public String insertEmpProc(EmpVO vo, Model model) {
		empService.insertEmp(vo);
		return "/temp/insertEmp";
	}
	
	@GetMapping("/getSearchEmp") //검색조회
	public String getSearchEmp(EmpVO vo, Model model) {
		model.addAttribute("list", empService.getSearchEmp(vo));
		return "/temp/getSearchEmp";
	}
}

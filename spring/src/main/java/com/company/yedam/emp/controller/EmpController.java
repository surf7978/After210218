package com.company.yedam.emp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.yedam.emp.dao.EmpVO;
import com.company.yedam.emp.service.DeptService;
import com.company.yedam.emp.service.EmpService;
import com.company.yedam.emp.service.JobService;

@Controller //@Component와 같은 의미 1.컨테이너에 빈으로 등록, 컨트롤러화시킴
public class EmpController {
	
	Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired EmpService empService;
	@Autowired DeptService deptService;
	@Autowired JobService jobService;
	
	//사원목록
	@RequestMapping("/empList")
	public String empList(Model model) {
		model.addAttribute("list", empService.empList());
		return "emp/empList";
	}
	
	//등록폼
	@GetMapping("/empInsert")
	public String empInsert(Model model) {
		model.addAttribute("jobList",  jobService.jobList());
		model.addAttribute("deptList",  deptService.deptList());
		return "emp/empInsert";
	}
	
	//등록처리
	@PostMapping("/empInsert")
	public String empInsertProc(EmpVO vo) {
		logger.debug(vo.toString()); //디버그하는것
		empService.empInsert(vo);
		return "redirect:empList";
	}
	//수정폼
	@RequestMapping("/empUpdate")
	public String empUpdate(EmpVO vo, Model model) {
		model.addAttribute("empVO", empService.selectOne(vo));
		
		model.addAttribute("jobList",  jobService.jobList());
		model.addAttribute("deptList",  deptService.deptList());
		
		return "emp/empInsert";
	}
	//수정처리
	@PostMapping("/empUpdate")
	public String empUpdateProc(EmpVO vo) {
		logger.debug(vo.toString()); //디버그하는것
		empService.empUpdate(vo);
		return "redirect:empList";
	}
	
	//이메일체크
	@RequestMapping("/empInsert")
	public String emailCheck(String id) {
//		empService.selectOneByEmail(id);
		return "emp/empInsert";
	}
	
	//사원검색
	@RequestMapping("/empSearch")
	public String empSearch(EmpVO vo, Model model) {
		model.addAttribute("list", empService.empSearch(vo));
		return "emp/empSearch";
	}
	
	//부서목록
	@RequestMapping("/deptList")
	public String deptList(Model model) {
		model.addAttribute("list", deptService.deptList());
		return "emp/deptList";
	}
}

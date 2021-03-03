package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.DeptVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.JobVO;
import com.yedam.emp.service.DeptService;
import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.JobService;

@Controller
public class EmpController {
	
	@Autowired EmpService empService;
	@Autowired DeptService deptService;
	@Autowired JobService jobService;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("/insertEmp") //등록페이지로 이동
	public String insertEmp(EmpVO vo) {
		return "/emp/insertEmp";
	}
	@PostMapping("/insertEmp") //등록처리
	public String insertEmpProc(EmpVO vo) {
		empService.insertEmp(vo);
		return "redirect:/getSearchEmp";
	}
	
	@GetMapping("/updateEmp") //수정페이지로 이동
	public String updateEmp(EmpVO empVO, Model model, DeptVO deptVO, JobVO jobVO) {
		model.addAttribute("empVO",empService.getEmp(empVO));
		model.addAttribute("deptList",deptService.getSearchDept(deptVO));
		model.addAttribute("jobList",jobService.getSearchJob(jobVO));
		return "/emp/updateEmp";
	}
	@PostMapping("/updateEmp") //수정처리
	public String updateEmpProc(EmpVO vo) {
		empService.updateEmp(vo);
		return "redirect:/getSearchEmp";
	}
	
	@GetMapping("/deleteEmp") //삭제처리
	public String deleteEmpProc(EmpVO vo) {
		empService.deleteEmp(vo);
		return "redirect:/getSearchEmp";
	}
	
	@GetMapping("/getEmp") //단건조회
	public String getEmp(EmpVO vo, Model model) {
		model.addAttribute("emp", empService.getEmp(vo));
		return "/emp/getEmp";
	}
	@GetMapping("/getSearchEmp") //검색조회
	public String getSearchEmp(EmpVO vo, Model model) {
		model.addAttribute("list", empService.getSearchEmp(vo));
		return "/emp/getSearchEmp";
	}
	
	@GetMapping("/getSearchDept") //검색조회
	public String getSearchDept(DeptVO vo, Model model) {
		model.addAttribute("list", deptService.getSearchDept(vo));
		return "/dept/getSearchDept";
	}
	@GetMapping("/getDept") //단건조회
	public String getDept(DeptVO vo, Model model) {
		model.addAttribute("dept", deptService.getDept(vo));
		return "/dept/getDept";
	}
	
	@GetMapping("/getSearchJob") //검색조회
	public String getSearchJob(JobVO vo, Model model) {
		model.addAttribute("list", jobService.getSearchJob(vo));
		return "/job/getSearchJob";
	}
	@GetMapping("/getJob") //단건조회
	public String getJob(JobVO vo, Model model) {
		model.addAttribute("job", jobService.getJob(vo));
		return "/job/getJob";
	}
}

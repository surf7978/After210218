package com.company.yedam.emp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.yedam.emp.dao.DeptDAO;
import com.company.yedam.emp.dao.EmpDAO;
import com.company.yedam.emp.dao.EmpVO;
import com.company.yedam.emp.dao.JobDAO;

@Controller //@Component와 같은 의미 1.컨테이너에 빈으로 등록, 컨트롤러화시킴
public class EmpController {
	
	Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired EmpDAO empDAO;
	@Autowired JobDAO jobDAO;
	@Autowired DeptDAO deptDAO;
	
	//사원목록
	@RequestMapping("/empList")
	public String empList(HttpServletRequest request) {
		request.setAttribute("list", empDAO.selectList());
		return "emp/empList";
	}
	
	//등록폼
	@GetMapping("/empInsert")
	public String empInsert(HttpServletRequest request) {
		request.setAttribute("jobList", jobDAO.selectList());
		request.setAttribute("deptList", deptDAO.selectList());
		return "emp/empInsert";
	}
	
	//등록처리
	@PostMapping("/empInsert")
	public String empInsertProc(EmpVO vo) {
		logger.debug(vo.toString()); //디버그하는것
		empDAO.insert(vo);
		return "redirect:empList";
	}
	//수정폼
	@RequestMapping("/empUpdate")
	public String empUpdate(HttpServletRequest request) {
		request.setAttribute("jobList", jobDAO.selectList());
		request.setAttribute("deptList", deptDAO.selectList());
		
		String empid = request.getParameter("employee_id");
		request.setAttribute("empVO", empDAO.selectOne(empid));
		return "emp/empInsert";
	}
	//수정처리
	@PostMapping("/empUpdate")
	public String empUpdateProc(EmpVO vo) {
		logger.debug(vo.toString()); //디버그하는것
		empDAO.update(vo);
		return "redirect:empList";
	}
	
	//이메일체크
	@RequestMapping("/empInsert")
	public String emailCheck(String id) {
		empDAO.selectOneByEmail(id);
		return "emp/empInsert";
	}
	
	//사원검색
	@RequestMapping("/empSearch")
	public String empSearch(HttpServletRequest request) {
		request.setAttribute("list", empDAO.selectList());
		return "emp/empSearch";
	}
}

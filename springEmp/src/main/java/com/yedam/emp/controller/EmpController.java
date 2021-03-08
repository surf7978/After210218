package com.yedam.emp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.DeptVO;
import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.EmpValidation;
import com.yedam.emp.JobVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.DeptService;
import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.JobService;

@Controller
public class EmpController {
	
	@Autowired EmpService empService;
	@Autowired DeptService deptService;
	@Autowired JobService jobService;
	
	//@Autowired EmpMapper empService;
	//@Autowired DeptMapper deptService;
	//@Autowired JobMapper jobService;
	
	@RequestMapping("/") //이건 다른컨트롤러 만들어도 하나만 적어줘야함 =유니크 속성
	public String main() {
		return "main";
	}
	
	@GetMapping("/insertEmp") //등록페이지로 이동
	public String insertEmp(EmpVO empVO, Model model, DeptVO deptVO, JobVO jobVO) {
//		deptVO.setStart(1);
//		deptVO.setEnd(1000);
		model.addAttribute("deptList",deptService.getSearchDept(deptVO));
		model.addAttribute("jobList",jobService.getSearchJob(jobVO));
		return "/emp/insertEmp";
	}
	@PostMapping("/insertEmp") //등록처리
	public String insertEmpProc(@Valid EmpVO vo, BindingResult result, Model model, DeptVO deptVO, JobVO jobVO) {
		//입력값 검증
		EmpValidation empValidation = new EmpValidation();
		empValidation.validate(vo, result);
		if(result.hasErrors()) {
			model.addAttribute("deptList",deptService.getSearchDept(deptVO));
			model.addAttribute("jobList",jobService.getSearchJob(jobVO));
			return "/emp/insertEmp"; //에러뜨면 다시 등록페이지로 이동
		}else { 					 //등록처리함
			empService.insertEmp(vo);
			return "redirect:/getSearchEmp";
		}
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
	
	//3. @PathVariable
	//@GetMapping("/getEmp/{employee_id}") 
	@GetMapping("/getEmp") //단건조회
	public String getEmp(
						Model model
						//2. 속성으로 대체 @=어노테이션
						//, HttpServletRequest request
//						, @RequestParam(value = "id"
//										,  required = false
//										, defaultValue = "100") String employee_id
						//3. @PathVariable
//						, @PathVariable String employee_id
						,@ModelAttribute("employee") EmpVO vo
						) {
		//1. getParameter
		//String employee_id = request.getParameter("employee_id");
		
//		EmpVO vo = new EmpVO();
//		vo.setEmployee_id(employee_id);
		
		model.addAttribute("emp", empService.getEmp(vo));
		return "/emp/getEmp";
	}
	@GetMapping("/getSearchEmp") //검색조회
	public String getSearchEmp(EmpSearchVO vo, Paging paging, Model model) {
		paging.setPageUnit(5); //한페이지에 표시되는 레코드 건수
		paging.setPageSize(3); //페이지번호수
		//페이징처리
		if(vo.getPage() == null) {
			vo.setPage(1);
		}
		//Paging 써서 이거 안해줘도됨(임시용이었음)
		//int start = (vo.getPage()-1)*10+1; //시작페이지 1번째페이지로 출력
		//int end = start+10-1; //1페이지에 10개씩 출력
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		paging.setTotalRecord(empService.getCount(vo));
		model.addAttribute("paging", paging);
		
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

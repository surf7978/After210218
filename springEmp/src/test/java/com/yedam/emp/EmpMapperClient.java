package com.yedam.emp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.emp.service.impl.EmpMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/*-context.xml")
public class EmpMapperClient {
	@Autowired EmpMapper empMapper;
	
	
	@Test
	public void insertEmp() {
		EmpVO vo = EmpVO.builder()
						.employee_id("4001")
						.first_name("na")
						.last_name("test1")
						.email("a@a.a")
						.hire_date(new java.sql.Date(new Date().getTime()))
						.job_id("IT_PROG")
						.phone_number("010-1111-1111")
						.department_id("20")
						.build();
		int result = empMapper.insertEmp(vo);
		assertEquals(result, 1);
	}
	
	@Test
	public void updateEmp() {
		EmpVO vo = EmpVO.builder()
				.email("a@a.bbbb")
				.employee_id("4000")
				.build();
		int result = empMapper.updateEmp(vo);
		assertEquals(result, 1);
	}
	
	@Test
	public void getSearchEmp() {
		EmpVO vo = EmpVO.builder().first_name("na").build();
		List<EmpVO> list = empMapper.getSearchEmp(vo);
		System.out.println(list);
	}
	
	@Test
	public void getEmp() {
		EmpVO vo = new EmpVO();
		vo.setEmployee_id("100");
		EmpVO resultVO = empMapper.getEmp(vo);
		//assertEquals("100", resultVO.getEmployee_id());
		assertNotNull(resultVO); // T/F
		System.out.println(resultVO);
	}
}

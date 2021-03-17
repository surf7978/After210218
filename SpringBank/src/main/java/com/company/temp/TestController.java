package com.company.temp;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	
	//get+post Mapping =RequestMapping 
	@RequestMapping("/getTest1")
	public String getTest1(TestVO vo) {
		System.out.println(vo);
		return "home";
	}
	
	//파라미터
	@RequestMapping("/getTest2")
	public String getTest2(@RequestParam String firstName
						   , @RequestParam int salary) {
		System.out.println(firstName+", "+salary);
		return "home";
	}
	
	//배열 request.getParameterValues()
	@RequestMapping("/getTest3")
	public String getTest3(@RequestParam String[] hobby) {
		for(int i=0; i<hobby.length; i++) { System.out.println(hobby[i]); }
		
		for(String Hobby : hobby) { System.out.println(Hobby); }
		
		System.out.println(Arrays.asList(hobby));
		return "home";
	}
	@RequestMapping("/getTest4")
	public String getTest4(@RequestParam("hobby") String[] hobbies) {
		System.out.println(Arrays.asList(hobbies));
		return "home";
	}
	
	//JSON방식은 get만 안 됨
	@RequestMapping("/getTest5")
	public String getTest5(@RequestBody TestVO vo) {
		System.out.println(vo);
		return "home";
	}
	@RequestMapping("/getTest6")
	public String getTest6(@RequestBody List<TestVO> list) {
		System.out.println(list);
		return "home";
	}
}

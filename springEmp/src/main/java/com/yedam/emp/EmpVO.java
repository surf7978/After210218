package com.yedam.emp;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpVO {
	@NotEmpty
	private String employee_id;
	@NotEmpty
	private String first_name;
	@NotEmpty(message = "last_name numm") //pom.xml에 dependency추가하면 이거 써서 바로 가능
	private String last_name;
	@NotEmpty
	private String email;
	@NotEmpty
	private String phone_number;
	//@NotEmpty
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hire_date;
	private String job_id;
	private String salary;
	private String commission_pct;
	private String manager_id;
	private String department_id;
	
	private String department_name;
	private String job_title;
	
	//게터세터만들때 lombok깔면 자동으로 만들어줘서 갱신할때 좋음
}

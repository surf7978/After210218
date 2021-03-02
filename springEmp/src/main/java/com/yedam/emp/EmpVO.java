package com.yedam.emp;

import java.sql.Date;

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
	private String employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private String salary;
	private String commission_pct;
	private String manager_id;
	private String department_id;
	
	//게터세터만들때 lombok깔면 자동으로 만들어줘서 갱신할때 좋음
}

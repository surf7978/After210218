package com.yedam.emp;

import lombok.Data;

@Data
public class DeptVO {
	int department_id;
	String department_name;
	int manager_id;
	int location_id;
}

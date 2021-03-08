package com.yedam.emp;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmpValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		EmpVO emp = (EmpVO) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last_name", null, "Empty last_name is now allowed.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hire_date", null, "Empty hire_date is now allowed.");
		
		if(emp.getEmployee_id() == null ||  emp.getEmployee_id().isEmpty()) {
			errors.rejectValue("employee_id", null, "employee_id not null");
		}
		if(emp.getEmail() == null ||  emp.getEmail().isEmpty()) {
			errors.rejectValue("email", null, "email not null");
		}
		if(emp.getJob_id() == null ||  emp.getJob_id().isEmpty()) {
			errors.rejectValue("job_id", null, "job_id not null");
		}
		if(emp.getDepartment_id() == null ||  emp.getDepartment_id().isEmpty()) {
			errors.rejectValue("department_id", null, "department_id not null");
		}
	}

}

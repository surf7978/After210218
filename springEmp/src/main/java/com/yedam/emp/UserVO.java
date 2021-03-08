package com.yedam.emp;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserVO {
	private String id;
	@NotEmpty
	private String password;
	private String name;
	private String role;
	@NotEmpty
	private String oldPassword;
	@NotEmpty
	private String newPassword;
}

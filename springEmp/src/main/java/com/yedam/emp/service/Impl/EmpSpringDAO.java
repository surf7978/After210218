package com.yedam.emp.service.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yedam.emp.EmpVO;

@Repository
public class EmpSpringDAO {
	@Autowired JdbcTemplate jdbc;
	
	private final String INSERT_EMP="INSERT INTO employees"//
									+ "("//
									+ "employee_id"//
									+ ", First_name"//
									+ ", last_name"//
									+ ", email"//
									+ ", hire_date"//
									+ ", job_id"//
									+ ", Phone_number"//
									+ ", Department_id"//
									+ ")"//
									+ " VALUES(?,?,?,?,?,?,?,?)";
	private final String UPDATE_EMP="UPDATE employees SET"//
									+ " First_name = ?"//
									+ ", last_name = ?"//
									+ ", email = ?"//
									+ ", hire_date = ?"//
									+ ", Phone_number = ?"//
									//+ ", job_id = ?"//
									//+ ", Department_id=?"//
									+ " WHERE employee_id = ?";
	private final String DELETE_EMP="DELETE FROM employees WHERE employee_id = ?";
	private final String GET_EMP="SELECT"//
									+ " Employee_id"//
									+ ", Last_name"//
									+ ", Email"//
									+ ", Hire_date"//
									+ ", Job_id"//
									+ ", First_name"//
									+ ", Salary"//
									+ ", Manager_id"//
									+ ", Department_id"//
									+ ", Phone_number"//
									+ " FROM employees WHERE employee_id = ?";
	private final String GET_SEARCH_EMP="SELECT"//
									+ " Employee_id"//
									+ ", First_name"//
									+ ", Last_name"//
									+ ", Email"//
									+ ", Hire_date"//
									+ ", Job_id"//
									+ ", Salary"//
									+ ", Manager_id"//
									+ ", Department_id"//
									+ ", Phone_number"//
									+ " FROM employees ORDER BY Hire_date DESC";
	
	//등록
	public int insertEmp(EmpVO vo) {
		int result = 0;
		result = jdbc.update(INSERT_EMP
									, vo.getEmployee_id()//
									, vo.getFirst_name()//
									, vo.getLast_name()//
									, vo.getEmail()//
									, vo.getHire_date()//
									, vo.getJob_id()//
									, vo.getPhone_number()//
									, vo.getDepartment_id()//
							);
		return result;
	}
	//수정
	public int updateEmp(EmpVO vo) {
		int result = 0;
		result = jdbc.update(UPDATE_EMP
									, vo.getFirst_name()//
									, vo.getLast_name()//
									, vo.getEmail()//
									, vo.getHire_date()//
									, vo.getPhone_number()//
									//, vo.getJob_id()//
									//, vo.getDepartment_id()//
									, vo.getEmployee_id()//
							);
		return result;
	}
	//삭제
	public int deleteEmp(EmpVO vo) {
		int result = 0;
		result = jdbc.update(DELETE_EMP
									, vo.getEmployee_id()//
							);
		return result;
	}
	//단건조회
	public EmpVO getEmp(EmpVO vo) {
		return jdbc.queryForObject(GET_EMP, new EmpRowMapper(), vo.getEmployee_id());
	}
	//검색조회
	public List<EmpVO> getSearchEmp(EmpVO vo) {
		return jdbc.query(GET_SEARCH_EMP, new EmpRowMapper());
	}
	
	
	
	//roewmapper
	class EmpRowMapper implements RowMapper<EmpVO> {

		@Override
		public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpVO vo = new EmpVO();
			vo.setEmployee_id(rs.getString("Employee_id"));
			vo.setFirst_name(rs.getString("First_name"));
			vo.setLast_name(rs.getString("Last_name"));
			vo.setEmail(rs.getString("Email"));
			vo.setHire_date(rs.getDate("Hire_date"));
			vo.setJob_id(rs.getString("Job_id"));
			vo.setSalary(rs.getString("Salary"));
			vo.setManager_id(rs.getString("Manager_id"));
			vo.setDepartment_id(rs.getString("Department_id"));
			vo.setPhone_number(rs.getString("Phone_number"));
			return vo;
		}
		
	}
}

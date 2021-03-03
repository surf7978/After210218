package com.yedam.emp.service.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yedam.emp.DeptVO;

@Repository
public class DeptSpringDAO {
	@Autowired JdbcTemplate jdbc;
	
	private final String INSERT_DEPT="INSERT INTO departments"//
									+ "("//
									+ "Department_id"//
									+ ", Department_name"//
									+ ", Manager_id"//
									+ ", Location_id"//
									+ ")"//
									+ " VALUES(?,?,?,?)";
	private final String UPDATE_DEPT="UPDATE departments SET"//
									+ " Department_name = ?"//
									+ ", Manager_id = ?"//
									+ ", Location_id = ?"//
									+ " WHERE Department_id = ?";
	private final String DELETE_DEPT="DELETE FROM departments WHERE Department_id = ?";
	private final String GET_DEPT="SELECT"//
									+ " Department_name"//
									+ ", Manager_id"//
									+ ", Location_id"//
									+ " FROM departments WHERE Department_id = ?";
	private final String GET_SEARCH_DEPT="SELECT"//
									+ " Department_id"//
									+ ", Department_name"//
									+ ", Manager_id"//
									+ ", Location_id"//
									+ " FROM departments";
	
	//등록
	public int insertEmp(DeptVO vo) {
		int result = 0;
		result = jdbc.update(INSERT_DEPT
									, vo.getDepartment_id()//
									, vo.getDepartment_name()//
									, vo.getManager_id()//
									, vo.getLocation_id()//
							);
		return result;
	}
	//수정
	public int updateEmp(DeptVO vo) {
		int result = 0;
		result = jdbc.update(UPDATE_DEPT
									, vo.getDepartment_name()//
									, vo.getManager_id()//
									, vo.getLocation_id()//
									, vo.getDepartment_id()//
							);
		return result;
	}
	//삭제
	public int deleteDept(DeptVO vo) {
		int result = 0;
		result = jdbc.update(DELETE_DEPT
									, vo.getDepartment_id()//
							);
		return result;
	}
	//단건조회
	public DeptVO getDept(DeptVO vo) {
		return jdbc.queryForObject(GET_DEPT, new DeptRowMapper(), vo.getDepartment_id());
	}
	//검색조회
	public List<DeptVO> getSearchDept(DeptVO vo) {
		return jdbc.query(GET_SEARCH_DEPT, new DeptRowMapper());
	}
	
	
	
	//roewmapper
	class DeptRowMapper implements RowMapper<DeptVO> {

		@Override
		public DeptVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			DeptVO vo = new DeptVO();
			vo.setDepartment_id(rs.getString("Department_id"));
			vo.setDepartment_name(rs.getString("Department_name"));
			vo.setLocation_id(rs.getString("Location_id"));
			vo.setManager_id(rs.getString("Manager_id"));
			return vo;
		}
		
	}
}

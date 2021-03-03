package com.yedam.emp.service.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yedam.emp.JobVO;

@Repository
public class JobSpringDAO {
	@Autowired JdbcTemplate jdbc;
	
	private final String INSERT_JOB="INSERT INTO jobs"//
									+ "("//
									+ "Job_id"//
									+ ", Job_title"//
									+ ", Min_salary"//
									+ ", Max_salary"//
									+ ")"//
									+ " VALUES(?,?,?,?)";
	private final String UPDATE_JOB="UPDATE jobs SET"//
									+ " Job_title = ?"//
									+ ", Min_salary = ?"//
									+ ", Max_salary = ?"//
									+ " WHERE Job_id = ?";
	private final String DELETE_JOB="DELETE FROM jobs WHERE Job_id = ?";
	private final String GET_JOB="SELECT"//
									+ ", Job_title"//
									+ ", Min_salary"//
									+ ", Max_salary"//
									+ " FROM jobs WHERE Job_id = ?";
	private final String GET_SEARCH_JOB="SELECT"//
									+ " Job_id"//
									+ ", Job_title"//
									+ ", Min_salary"//
									+ ", Max_salary"//
									+ " FROM jobs";
	
	//등록
	public int insertJob(JobVO vo) {
		int result = 0;
		result = jdbc.update(INSERT_JOB
									, vo.getJob_id()//
									, vo.getJob_title()//
									, vo.getMin_salary()//
									, vo.getMax_salary()//
							);
		return result;
	}
	//수정
	public int updateJob(JobVO vo) {
		int result = 0;
		result = jdbc.update(UPDATE_JOB
									, vo.getJob_title()//
									, vo.getMin_salary()//
									, vo.getMax_salary()//
									, vo.getJob_id()//
							);
		return result;
	}
	//삭제
	public int deleteJob(JobVO vo) {
		int result = 0;
		result = jdbc.update(DELETE_JOB
									, vo.getJob_id()//
							);
		return result;
	}
	//단건조회
	public JobVO getJob(JobVO vo) {
		return jdbc.queryForObject(GET_JOB, new JobRowMapper(), vo.getJob_id());
	}
	//검색조회
	public List<JobVO> getSearchJob(JobVO vo) {
		return jdbc.query(GET_SEARCH_JOB, new JobRowMapper());
	}
	
	
	
	//roewmapper
	class JobRowMapper implements RowMapper<JobVO> {

		@Override
		public JobVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			JobVO vo = new JobVO();
			vo.setJob_title(rs.getString("Job_title"));
			vo.setJob_id(rs.getString("Job_id"));
			vo.setMin_salary(rs.getString("Min_salary"));
			vo.setMax_salary(rs.getString("Max_salary"));
			return vo;
		}
		
	}
}

package com.company.yedam.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class JobDAO {
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	public ArrayList<JobVO> selectList() {
		ArrayList<JobVO> list = new ArrayList<>();
		Connection conn = JdbcUtil.connect();
		String sql = "SELECT"
				+ " JOB_ID"
				+ ", JOB_TITLE"
				+ ", MIN_SALARY"
				+ ", MAX_SALARY"
				+ " FROM JOBS ORDER BY JOB_TITLE DESC";
		JobVO vo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new JobVO();
				vo.setJob_id(rs.getString("JOB_ID"));
				vo.setJob_title(rs.getString("JOB_TITLE"));
				vo.setMin_salary(rs.getInt("MIN_SALARY"));
				vo.setMax_salary(rs.getInt("MAX_SALARY"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.disconnect(conn);
		}
		return list;
	}
}

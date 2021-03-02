package com.company.yedam.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

/**
 * VO = Value Object = DTO = DO
 * DAO = Data Access Object
 */
@Repository //@Component상속
public class EmpDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//singletone @Component사용하면 싱글톤 필요없음
//	private static EmpDAO instance;
//	public static EmpDAO getInstance() {
//		if(instance == null) {
//			instance = new EmpDAO();
//		}
//		return instance;
//	}
	
	public void insert(EmpVO vo) {
		try {
			//1. connect(연결)
			conn = JdbcUtil.connect();
			//2. statement(구문)
			/**
			 * String sql = "insert values('"+vo.getFirst_name()+"');
			 * 이렇게 번거롭게 적느니 PreparedStatement 사용하는게 좋음
			 * Statement stat = conn.createStatement();
			 */
			String sql = "INSERT INTO employees"//
					+ "("//
					+ "employee_id"//
					+ ", last_name"//
					+ ", email"//
					+ ", hire_date"//
					+ ", job_id"//
					+ ", First_name"//
					+ ", Phone_number"//
					+ ")"//
					+ " VALUES(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getEmployee_id());
			pstmt.setString(2, vo.getLast_name());
			pstmt.setString(3, vo.getEmail());
			pstmt.setDate(4, vo.getHire_date());
			pstmt.setString(5, vo.getJob_id());
			pstmt.setString(6, vo.getFirst_name());
			pstmt.setString(7, vo.getPhone_number());
			//3. execute(실행)
			int r = pstmt.executeUpdate();
			//4. resultset(select라면 조회결과처리)
			System.out.println(r+"건 등록됨");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//5. close(연결해제)
			JdbcUtil.disconnect(conn);
		}
	}
	
	public void update(EmpVO vo) {
		try {
			//1. connect(연결)
			conn = JdbcUtil.connect();
			//2. statement(구문)
			String sql = "UPDATE employees SET"//
					+ " last_name = ?"//
					+ ", email = ?"//
					+ ", hire_date = ?"//
					+ ", job_id = ?"//
					+ ", First_name = ?"//
					+ ", Phone_number = ?"//
					+ " WHERE employee_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getLast_name());
			pstmt.setString(2, vo.getEmail());
			pstmt.setDate(3, vo.getHire_date());
			pstmt.setString(4, vo.getJob_id());
			pstmt.setString(5, vo.getFirst_name());
			pstmt.setString(6, vo.getPhone_number());
			pstmt.setString(7, vo.getEmployee_id());
			//3. execute(실행)
			pstmt.executeUpdate();
			//4. resultset(select라면 조회결과처리)
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//5. close(연결해제)
			JdbcUtil.disconnect(conn);
		}
	}
	
	public EmpVO selectOne(String id) {
		conn = JdbcUtil.connect();
		String sql = "SELECT"
				+ " Employee_id"
				+ ", Last_name"
				+ ", Email"
				+ ", Hire_date"
				+ ", Job_id"
				+ ", First_name"
				+ ", Salary"
				+ ", Manager_id"
				+ ", Department_id"
				+ ", Phone_number"
				+ " FROM employees WHERE employee_id = ?";
		EmpVO vo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new EmpVO();
				vo.setEmployee_id(rs.getString("Employee_id"));
				vo.setLast_name(rs.getString("Last_name"));
				vo.setFirst_name(rs.getString("First_name"));
				vo.setEmail(rs.getString("Email"));
				vo.setHire_date(rs.getDate("Hire_date"));
				vo.setJob_id(rs.getString("Job_id"));
				vo.setSalary(rs.getString("Salary"));
				vo.setManager_id(rs.getString("Manager_id"));
				vo.setDepartment_id(rs.getString("Department_id"));
				vo.setPhone_number(rs.getString("Phone_number"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.disconnect(conn);
		}
		return vo;
	}
	
	public ArrayList<EmpVO> selectList() {
		ArrayList<EmpVO> list = new ArrayList<>();
		conn = JdbcUtil.connect();
		String sql = "SELECT Employee_id"
				+ ", Last_name"
				+ ", Email"
				+ ", Hire_date"
				+ ", Job_id"
				+ ", First_name"
				+ ", Salary"
				+ ", Manager_id"
				+ ", Department_id"
				+ ", Phone_number"
				+ " FROM employees ORDER BY Hire_date DESC";
		EmpVO vo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new EmpVO();
				vo.setEmployee_id(rs.getString("Employee_id"));
				vo.setLast_name(rs.getString("Last_name"));
				vo.setFirst_name(rs.getString("First_name"));
				vo.setEmail(rs.getString("Email"));
				vo.setHire_date(rs.getDate("Hire_date"));
				vo.setJob_id(rs.getString("Job_id"));
				vo.setSalary(rs.getString("Salary"));
				vo.setManager_id(rs.getString("Manager_id"));
				vo.setDepartment_id(rs.getString("Department_id"));
				vo.setPhone_number(rs.getString("Phone_number"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.disconnect(conn);
		}
		return list;
	}
	
	public EmpVO selectOneByEmail(String id) {
		conn = JdbcUtil.connect();
		String sql = "SELECT"
				+ " Employee_id"
				+ ", Last_name"
				+ ", Email"
				+ ", Hire_date"
				+ ", Job_id"
				+ ", First_name"
				+ ", Salary"
				+ ", Manager_id"
				+ ", Department_id"
				+ ", Phone_number"
				+ " FROM employees WHERE Email = ?";
		EmpVO vo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new EmpVO();
				vo.setEmployee_id(rs.getString("Employee_id"));
				vo.setLast_name(rs.getString("Last_name"));
				vo.setFirst_name(rs.getString("First_name"));
				vo.setEmail(rs.getString("Email"));
				vo.setHire_date(rs.getDate("Hire_date"));
				vo.setJob_id(rs.getString("Job_id"));
				vo.setSalary(rs.getString("Salary"));
				vo.setManager_id(rs.getString("Manager_id"));
				vo.setDepartment_id(rs.getString("Department_id"));
				vo.setPhone_number(rs.getString("Phone_number"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.disconnect(conn);
		}
		return vo;
	}
	
	public EmpVO selectOneByManagerId(String id) {
		conn = JdbcUtil.connect();
		String sql = "SELECT"
				+ " Employee_id"
				+ ", Last_name"
				+ ", Email"
				+ ", Hire_date"
				+ ", Job_id"
				+ ", First_name"
				+ ", Salary"
				+ ", Manager_id"
				+ ", Department_id"
				+ ", Phone_number"
				+ " FROM employees WHERE Manager_id = ?";
		EmpVO vo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new EmpVO();
				vo.setEmployee_id(rs.getString("Employee_id"));
				vo.setLast_name(rs.getString("Last_name"));
				vo.setFirst_name(rs.getString("First_name"));
				vo.setEmail(rs.getString("Email"));
				vo.setHire_date(rs.getDate("Hire_date"));
				vo.setJob_id(rs.getString("Job_id"));
				vo.setSalary(rs.getString("Salary"));
				vo.setManager_id(rs.getString("Manager_id"));
				vo.setDepartment_id(rs.getString("Department_id"));
				vo.setPhone_number(rs.getString("Phone_number"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.disconnect(conn);
		}
		return vo;
	}
}

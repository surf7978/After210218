package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * VO = Value Object = DTO = DO
 * DAO = Data Access Object
 */
public class EmpDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void insert(EmpVO vo) {
		try {
			//1. connect(연결)
			JdbcUtil.connect();
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
					+ ")"//
					+ " VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getEmployee_id());
			pstmt.setString(2, vo.getLast_name());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getHire_date());
			pstmt.setString(5, vo.getJob_id());
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
			JdbcUtil.connect();
			//2. statement(구문)
			String sql = "UPDATE employees SET"//
					+ " last_name=?"//
					+ ", email=?"//
					+ ", hire_date=?"//
					+ ", job_id=?"//
					+ " WHERE employee_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getLast_name());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getHire_date());
			pstmt.setString(4, vo.getJob_id());
			pstmt.setString(5, vo.getEmployee_id());
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
		JdbcUtil.connect();
		String sql = "SELECT Employee_id, Last_name, Email, Hire_date, Job_id"
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
				vo.setEmail(rs.getString("Email"));
				vo.setHire_date(rs.getString("Hire_date"));
				vo.setJob_id(rs.getString("Job_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.disconnect(conn);
		}
		return vo;
	}
	
	public List<EmpVO> selectAll() {
		ArrayList<EmpVO> list = new ArrayList<>();
		JdbcUtil.connect();
		String sql = "SELECT Employee_id, Last_name, Email, Hire_date, Job_id"
				+ " FROM employees ORDER BY Hire_date DESC";
		EmpVO vo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new EmpVO();
				vo.setEmployee_id(rs.getString("Employee_id"));
				vo.setLast_name(rs.getString("Last_name"));
				vo.setEmail(rs.getString("Email"));
				vo.setHire_date(rs.getString("Hire_date"));
				vo.setJob_id(rs.getString("Job_id"));
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

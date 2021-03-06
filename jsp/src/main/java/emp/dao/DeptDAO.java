package emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeptDAO {
	PreparedStatement pstmt;
	ResultSet rs;
	
	//singletone
		private static DeptDAO instance;
		public static DeptDAO getInstance() {
			if(instance == null) {
				instance = new DeptDAO();
			}
			return instance;
		}
	
	public ArrayList<DeptVO> selectList() {
		ArrayList<DeptVO> list = new ArrayList<>();
		Connection conn = JdbcUtil.connect();
		String sql = "SELECT"
				+ " DEPARTMENT_ID"
				+ ", DEPARTMENT_NAME"
				+ ", MANAGER_ID"
				+ ", LOCATION_ID"
				+ " FROM DEPARTMENTS ORDER BY DEPARTMENT_ID DESC";
		DeptVO vo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new DeptVO();
				vo.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				vo.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
				vo.setManager_id(rs.getInt("MANAGER_ID"));
				vo.setLocation_id(rs.getInt("LOCATION_ID"));
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

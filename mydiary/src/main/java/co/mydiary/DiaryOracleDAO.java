package co.mydiary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DiaryOracleDAO implements DAO {
	Connection conn = JdbcUtil.connect();
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	@Override
	public int insert(DiaryVO vo) {
		String sql = "INSERT INTO diary(wdate, contents) VALUES(?, ?)";
		int n = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWdate());
			pstmt.setString(2, vo.getContents());
			n = pstmt.executeUpdate();
			System.out.println(n+"건 등록");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public void update(DiaryVO vo) {
		String sql = "UPDATE diary SET contents = ? WHERE wdate = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getContents());
			pstmt.setString(2, vo.getWdate());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int delete(String date) {
		String sql = "DELETE FROM diary WHERE wdate = ?";
		int n = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, date);
			n = pstmt.executeUpdate();
			System.out.println(n+"건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public DiaryVO selectDate(String date) {
		DiaryVO vo = null;
		String sql = "SELECT * FROM diary WHERE wdate = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, date);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new DiaryVO();
				vo.setWdate(rs.getString("wdate"));
				vo.setContents(rs.getString("contents"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<DiaryVO> selectContent(String content) {
		List<DiaryVO> list = new ArrayList<>();
		DiaryVO vo = null;
		String sql = "SELECT * FROM diary WHERE contents like ?";
		//String sql = "SELECT * FROM diary WHERE contents like '%' || ? || '%'";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+content+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new DiaryVO();
				vo.setWdate(rs.getString("wdate"));
				vo.setContents(rs.getString("contents"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<DiaryVO> selectAll() {
		ArrayList<DiaryVO> list = new ArrayList<>();
		DiaryVO vo = null;
		String sql = "SELECT * FROM diary";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new DiaryVO();
				vo.setWdate(rs.getString("wdate"));
				vo.setContents(rs.getString("contents"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}

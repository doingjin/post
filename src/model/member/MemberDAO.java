package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JDBC;

public class MemberDAO {
	
	String sql_selectONE="SELECT * FROM MEMBER WHERE ID=?";
	String sql_insert="INSERT INTO MEMBER VALUES (?,?)";
	String sql_update="UPDATE MEMBER SET PW=? WHERE ID=?";
	String sql_delete="DELETE FROM MEMBER WHERE ID=?";
	
	public MemberVO getMB(MemberVO vo) {
		MemberVO data=null;
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql_selectONE);
			pstmt.setString(1, vo.getId());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MemberVO();
				data.setId(rs.getString("id"));
				data.setPw(rs.getString("pw"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("getMB()에서 출력");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return data;
	}
	
	public boolean newMB(MemberVO vo) {
		boolean res=false;
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.executeUpdate();
			res=true;
		} catch (SQLException e) {
			System.out.println("newMB()에서 출력");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return res;
	}
	
	public boolean updateMB(MemberVO vo) {
		boolean res=false;
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql_update);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getId());
			pstmt.executeUpdate();
			res=true;
		} catch (SQLException e) {
			System.out.println("updateMB()에서 출력");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return res;
	}
	
	public boolean deleteMB(MemberVO vo) {
		boolean res=false;
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql_delete);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
			res=true;
		} catch (SQLException e) {
			System.out.println("updateMB()에서 출력");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return res;
	}
}

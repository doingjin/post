package model.message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBC;


public class MessageDAO {

	String sql_selectALL="SELECT * FROM MESSAGE ORDER BY NUM DESC";  // ✔✔
	String sql_selectONE="SELECT * FROM MESSAGE WHERE NUM=?";  // ✔✔
	String sql_insert="INSERT INTO MESSAGE VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM MESSAGE),?,?,?,sysdate)";
	  // ✔✔
	String sql_update="UPDATE MESSAGE SET TITLE=?,CONTENT=? WHERE NUM=?";  // ✔✔
	String sql_delete="DELETE FROM MESSAGE WHERE NUM=?";   // ✔✔
	
	
	public ArrayList<MessageVO> getMSGlist(){
		ArrayList<MessageVO> datas=new ArrayList();
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql_selectALL);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				MessageVO data=new MessageVO();
				data.setNum(rs.getInt("num"));
				data.setId(rs.getString("id"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("getMSGlist()에서 출력");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public MessageVO getMSG(MessageVO vo) {
		MessageVO data=null;
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql_selectONE);
			pstmt.setInt(1, vo.getNum());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MessageVO();
				data.setNum(rs.getInt("num"));
				data.setId(rs.getString("id"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("getMSG()에서 출력");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return data;
	}
	
	public boolean newMSG(MessageVO vo) {
		boolean res=false;
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			res=true;
		} catch (SQLException e) {
			System.out.println("newPost()에서 출력");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return res;
	}
	
	public boolean editMSG(MessageVO vo) {
		boolean res=false;
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql_update);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNum());
			pstmt.executeUpdate();
			res=true;
		} catch (SQLException e) {
			System.out.println("editMSG()에서 출력");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return res;
	}
	
	public boolean deleteMSG(MessageVO vo) {
		boolean res=false;
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql_delete);
			pstmt.setInt(1, vo.getNum());
			pstmt.executeUpdate();
			res=true;
		} catch (SQLException e) {
			System.out.println("deleteMSG()에서 출력");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return res;
	}
}

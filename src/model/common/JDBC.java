package model.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC {
	
	public static Connection connect() {
		String Driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn=null;
		try {
			Class.forName(Driver);
			conn=DriverManager.getConnection(url, "jin", "1230");
		} catch (Exception e) {
			System.out.println("connect()에서 출력");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void disconnect(PreparedStatement pstmt, Connection conn) {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("disconnect()에서 출력");
			e.printStackTrace();
		}	
	}
}

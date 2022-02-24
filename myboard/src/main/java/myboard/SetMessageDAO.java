package myboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SetMessageDAO {

	public void insertMessage(Message message) {
		Connection conn = null;
		String sql = "insert into message_board(board_id, message_title, message_text, userid, stime)\r\n"
				+ "values(message_board_seq.nextval,?,?,?,sysdate)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521/XEPDB1", "hr", "sGezExgxfI$922");
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, message.getMessageTitle());
			ps.setString(2, message.getMessageText());
			ps.setString(3, message.getUserid());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
			}catch (SQLException e2) {
				
			}
		}
	}
	
	public void deleteMessage(Message message) {
		Connection conn = null;
		String sql = "delete from message_board\r\n" + "where board_id = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521/XEPDB1", "hr", "sGezExgxfI$922");
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, message.getBoardId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {

			}
		}
	}
	
	public void updateMessage(Message message) {
		Connection conn = null;
		String sql = "update message_board\r\n"
				+ "set message_title = ?, \r\n"
				+ "message_text = ?, \r\n"
				+ "stime = sysdate \r\n"
				+ "where board_id = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521/XEPDB1", "hr", "sGezExgxfI$922");
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, message.getMessageTitle());
			ps.setString(2, message.getMessageText());
			ps.setInt(3, message.getBoardId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e2) {

			}
		}
	}
}

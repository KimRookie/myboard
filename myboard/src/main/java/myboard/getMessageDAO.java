package myboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class getMessageDAO {
	
	public Map<Integer, String> getMessage(int board_id){
		Connection conn = null;
		Map<Integer, String> list = null;
		String sql = "select b.board_id, b.message_title, b.message_text, u.name userid, b.stime \r\n"
				+ "from message_board b, users u \r\n"
				+ "where b.userid = u.userid \r\n"
				+ "and b.board_id = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521/XEPDB1", "hr", "sGezExgxfI$922");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, board_id);
			ResultSet rs = ps.executeQuery();
			list = new HashMap<>();
			if(rs.next()) {
				list.put(1, rs.getString(1));
				list.put(2, rs.getString(2));
				list.put(3, rs.getString(3));
				list.put(4, rs.getString(4));
				list.put(5, rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				
			}
			
		}
			return list;
	}
	
	public List<Map<Integer, String>> getMessageList() {
		Connection conn = null;
		List<Map<Integer, String>> list = null;
		
		String sql = "select b.board_id, b.message_title, u.name userid, b.stime \r\n"
				+ "from message_board b, users u \r\n"
				+ "where b.userid = u.userid \r\n"
				+ "order by stime desc";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521/XEPDB1", "hr", "sGezExgxfI$922");
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				Map<Integer, String> map = new HashMap<>();
				map.put(1, rs.getString("board_id"));
				map.put(2, rs.getString("message_title"));
				map.put(3, rs.getString("userid"));
				map.put(4, rs.getString("stime"));
				list.add(map);
			}
			
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
		
		return list;
	}
}

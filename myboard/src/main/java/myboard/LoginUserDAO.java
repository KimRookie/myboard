package myboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class LoginUserDAO {
	
	public Account login(Account loginInfo) {
		Connection conn = null;
		Account account = null;
		String sql = "select * from users where email = ? and pass = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521/XEPDB1", "hr", "sGezExgxfI$922");
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, loginInfo.getEmail());
			ps.setString(2, loginInfo.getPass());
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				String email = rs.getString("email");
				String name = rs.getString("name");
				String pass = rs.getString("pass");
				String userid = rs.getString("userid");
				account = new Account();
				account.setEmail(email);
				account.setName(name);
				account.setPass(pass);
				account.setUserId(userid);
			}
			
		}catch (Exception e) {
			System.out.println("접속 성공");
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		
		return account;
	}
	
	public void register(Account account) {
		Connection conn = null;
		String sql = "insert into users(email, pass, name, userid)" + "values(?,?,?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.123.100:1521/XEPDB1", "hr", "sGezExgxfI$922");
			System.out.println("회원가입");
			PreparedStatement ps = conn.prepareStatement(sql);
			
			String uuid = UUID.randomUUID().toString();
			
			ps.setString(1, account.getEmail());
			ps.setString(2, account.getPass());
			ps.setString(3, account.getName());
			ps.setString(4, uuid);
			
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e2) {

			}
		}
	}
}

package myboard;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginUser extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public LoginUser() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		System.out.println("email = " + email);
		System.out.println("pass = " + pass);
		
		Account loginInfo = new Account(email, pass);
		LoginUserDAO dao = new LoginUserDAO();
		Account account = dao.login(loginInfo);
		
		if (account == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginFail.jsp");
			dispatcher.forward(request, response);
		} else {
			System.out.println("접속 성공");
			
			HttpSession session = request.getSession();
			session.setAttribute("username", account.getName());
			session.setAttribute("userid", account.getUserId());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/board.jsp");
			dispatcher.forward(request, response);
		}
	}
}

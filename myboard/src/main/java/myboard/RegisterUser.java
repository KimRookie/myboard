package myboard;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterUser extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public RegisterUser() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		
		if((email.equals("") || pass.equals("") || name.equals(""))) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/registerBad.jsp");
			dispatcher.forward(request, response);
		}
		
		Account account = new Account(email, pass, name);
		LoginUserDAO dao = new LoginUserDAO();
		dao.register(account);
		
		response.getWriter().println(
				"이메일: " + email + "<br>" +
				"패스워드: " + pass + "<br>" +
				"이름: " + name);
	}
}

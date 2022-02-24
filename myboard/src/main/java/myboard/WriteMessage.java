package myboard;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WriteMessage extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public WriteMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		String writer = req.getParameter("writer");
		Message message = new Message(title, contents, writer);
		SetMessageDAO dao = new SetMessageDAO();
		dao.insertMessage(message);
		resp.sendRedirect("/myboard/board.jsp");
	}
	
	
}

package myboard;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Update extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public Update() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Integer id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		String writer = req.getParameter("writer");
		
		Message message = new Message(id, title, contents, writer);
		SetMessageDAO dao = new SetMessageDAO();
		dao.updateMessage(message);
		
		resp.sendRedirect("/myboard/board.jsp");
	}

}

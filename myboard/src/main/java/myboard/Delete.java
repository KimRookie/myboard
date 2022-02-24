package myboard;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Delete() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Message message = new Message();
		message.setBoardId(id);
		SetMessageDAO dao = new SetMessageDAO();
		dao.deleteMessage(message);
		
		resp.sendRedirect("/myboard/board.jsp");
	}
	
	

}

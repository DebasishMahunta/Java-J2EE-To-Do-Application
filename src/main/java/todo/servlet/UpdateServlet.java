package todo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.DB.DBConnect;
import todo.dao.TodoDao;
import todo.entity.TodoEntity;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		String todo = req.getParameter("todo");
		String status = req.getParameter("status");
		
		TodoDao dao = new TodoDao(DBConnect.getCon());
		
		TodoEntity t = new TodoEntity();
		t.setId(id);
		t.setName(username);
		t.setTodo(todo);
		t.setStatus(status);
		
		boolean f = dao.updateTodo(t);
		HttpSession session = req.getSession();
		if(f) {
			session.setAttribute("sucMsg","Todo Update Sucessfully");
			resp.sendRedirect("index.jsp");
		} else {
			session.setAttribute("filedMsg","Something wrong on server");
			resp.sendRedirect("index.jsp"); 
		}
		
		
	}
	
	
}

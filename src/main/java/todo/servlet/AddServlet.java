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

@WebServlet("/add_todo")
public class AddServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String todo = req.getParameter("todo");
		String status = req.getParameter("status");
		
		TodoDao dao = new TodoDao(DBConnect.getCon());
		boolean f = dao.addTodo(username, todo, status);
		
		HttpSession session = req.getSession();
		
		if(f) {
			session.setAttribute("sucMsg","Todo Added Sucessfully");
			resp.sendRedirect("index.jsp");
		} else {
			session.setAttribute("filedMsg","Something wrong on server");
			resp.sendRedirect("index.jsp"); 
		}
	}
	
	
}

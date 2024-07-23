
<%@page import="todo.entity.TodoEntity"%>
<%@page import="java.util.List"%>
<%@page import="todo.DB.DBConnect"%>
<%@page import="todo.dao.TodoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="component/all_css.jsp"%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<h1 class="text-center text-success">TODO APPLICATION</h1>
	<%
	String sucMsg = (String) session.getAttribute("sucMsg");
	if (sucMsg != null) {
	%>
	<div class="alert alert-success" role="alert"><%=sucMsg%></div>
	<%
	session.removeAttribute("sucMsg");
	}
	%>

	<%
	String filedMsg = (String) session.getAttribute("filedMsg");
	if (filedMsg != null) {
	%>
	<div class="alert alert-danger" role="alert"><%=filedMsg%></div>
	<%
	session.removeAttribute("filedMsg");
	}
	%>

	<div class="container">
		<table class="table table-striped" border="1px">
			<thead class="bg-success text-white">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">ToDo</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				TodoDao dao = new TodoDao(DBConnect.getCon());
				List<TodoEntity> todo = dao.getTodo();
				for (TodoEntity t : todo) {
				%>
				<tr>
					<th scope="row"><%=t.getId() %></th>
					<td scope="col"><%=t.getName() %></td>
					<td><%=t.getTodo() %></td>
					<td><%=t.getStatus() %></td>
					<td><a href="edit.jsp?id=<%=t.getId()%>" class="btn btn-sm btn-success">Edit</a> 
					<a href="delete?id=<%=t.getId()%>" class="btn btn-sm btn-danger">Delete</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>
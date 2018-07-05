<%@page import="com.jac.web.controller.Globals"%>
<%@page import="com.jac.web.model.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
			Book book = (Book) request.getAttribute("book");
		%>
		<% if(book!=null){ %>
		<%=book.getTitle() %>
		<%}else{ %>
		<h2>New Book</h2>
		<%} %>
</body>
</html>
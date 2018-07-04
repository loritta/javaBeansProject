
<%@page import="com.jac.web.controller.Globals"%>
<%@page import="com.jac.web.model.User"%>

<%if(Globals.IsAuthorized){
	 User u = (User)request.getAttribute("user"); %>
	
	<ul class="nav navbar-nav navbar-right">

	<li><a href="#">Hello, <%=u.getFirstName()+" "+u.getLastName() %></a></li>
	<li><a href="welcome.jsp">Log off</a></li>
</ul>
	
<%}%>




<%@page import="com.jac.web.controller.Globals"%>
<%@page import="com.jac.web.model.User"%>

<%if(Globals.IsAuthorized){%>
	
	<ul class="nav navbar-nav navbar-right">

	<li><a href="#">Hello, <%=Globals.FullName %></a></li>
	<li><a href="logoff">Log off</a></li>
</ul>
	
<%}%>



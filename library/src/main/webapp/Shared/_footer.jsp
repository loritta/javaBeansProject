
<%
	String uri = request.getRequestURI();
	String pageName = uri.substring(uri.lastIndexOf("/") + 1);
%>
<footer
	<%if (pageName.equals("welcome.jsp")) {
		out.print("class='footer-welcome'");
	}else{
		out.print("class='footer-main'");
	}%>>
	<hr>

	<p>Developed by Larisa, Jie, Qian, Roman, Yasser - IPD12</p>
</footer>
<%@page import="com.jac.web.controller.Globals"%>
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="GoToAdmin"><img src="images/logo.png" class="scaleImg"
				style="height: 70px; margin-right: 25px" /></a> 

<!-- 				<a href="index.jsp" -->
<!-- 				class="navbar-brand">EJB Library</a> -->
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="<%=Globals.RootPath%>/GoToAdmin">Books manager</a>
				<li><a href="<%=Globals.RootPath%>/GoToAdminUser">User manager</a>
			</ul>
		   
		   <jsp:include page="_navbarRight.jsp"></jsp:include>
		
		</div>
	</div>
</div>
<%@page import="com.jac.web.controller.Globals"%>
<%Globals.IsAuthorized=false; Globals.IsAdmin=false;%>
<!DOCTYPE html>
<html>
<jsp:include page="Shared/_head.jsp"></jsp:include>

<body>
   <jsp:include page="Shared/_navbarUser.jsp"></jsp:include>


    <br />
    <br />
    <div class="container body-content" style="margin-top:45px">
        
        
<!--         THE BODY CONTENT STARTS HERE -->
        
        <h2>Welcome to EJB Library!</h2>
        <br/>

		<form class="form-horizontal" action="login" method="post"
			id="loginForm" name="loginForm" onsubmit="return validateForm();">
			<div class="form-group">
				<label class="control-label col-sm-2" for="username">Username:</label>
				<div class="col-sm-4">
					<input name="username" id="username" class="form-control"
						type="text" placeholder="" maxlength="50" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="password">Password:</label>
				<div class="col-sm-4">
					<input name="password" id="password" class="form-control"
						type="password" placeholder="" maxlength="50" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2"></label>
				<div class="col-sm-4">
					<button type="submit" class="btn btn-primary">Login</button>
				</div>
			</div>
		</form>


		<!--         END OF THE BODY CONTENT-->
        
      
        <hr />
        
        <jsp:include page="Shared/_footer.jsp"></jsp:include>
    </div>

<jsp:include page="Shared/_scripts_bundle.jsp"></jsp:include>
</body>

</html>
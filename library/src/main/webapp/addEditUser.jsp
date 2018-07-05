<%@page import="com.jac.web.controller.Globals"%>
<%@page import="com.jac.web.model.User"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<jsp:include page="Shared/_head.jsp"></jsp:include>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <jsp:include page="Shared/_navbarAdmin.jsp"></jsp:include>
 

    <br />
    <br />
    <div class="container body-content" style="margin-top:45px">
        
        
<!--         THE BODY CONTENT STARTS HERE -->
        
		<%
			User user = (User) request.getAttribute("user");
		%>
        <%if(user==null){ %>

        <h1> Add User</h1>
        
        <form class="form-horizontal" action="AddUser" method="post"
			id="" name="" onsubmit="return validateForm();">
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
				<label class="control-label col-sm-2" for="passwordRe">Retype Password:</label>
				<div class="col-sm-4">
					<input name="passwordRe" id="passwordRe" class="form-control"
						type="text" placeholder="" maxlength="50" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="role">Role:</label>
				<div class="col-sm-4">
				<select name="role" id="role" class="form-control">
				
					<c:forEach items="${listRoles}" var="role">
        			<option value="${role.id}">${role.name}</option>
    			</c:forEach>
				</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="firstName">First Name:</label>
				<div class="col-sm-4">
					<input name="firstName" id="firstName" class="form-control"
						type="text" placeholder="" maxlength="50" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="lastName">Last Name:</label>
				<div class="col-sm-4">
					<input name="lastName" id="lastName" class="form-control"
						type="text" placeholder="" maxlength="50" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="phone">Phone:</label>
				<div class="col-sm-4">
					<input name="phone" id="phone" class="form-control"
						type="text" placeholder="" maxlength="50" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="address">Address:</label>
				<div class="col-sm-4">
					<input name="address" id="address" class="form-control"
						type="text" placeholder="" maxlength="50" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="city">City:</label>
				<div class="col-sm-4">
					<input name="city" id="city" class="form-control"
						type="text" placeholder="" maxlength="50" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="province">Province:</label>
				<div class="col-sm-4">
				<select name="province" id="province" class="form-control">
				<option>Please select a Province</option>
				<option value="QC">QC</option>
				<option value="ON">ON</option>
				</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="zipcode">Zipcode:</label>
				<div class="col-sm-4">
					<input name="zipcode" id="zipcode" class="form-control"
						type="text" placeholder="" maxlength="50" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2"></label>
				<div class="col-sm-4">
					<button type="submit" class="btn btn-primary">Add/Edit User</button>
				</div>
			</div>
		</form>        
        <%}else{ %>
        <h1> Edit User</h1>
        
        <form class="form-horizontal" action="AddUser" method="post"
			id="" name="" onsubmit="return validateForm();">
			<div class="form-group">
				<label class="control-label col-sm-2" for="username">Username:</label>
				<div class="col-sm-4">
					<input value="<%=user.getUsername() %>" name="username" id="username" class="form-control"
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
				<label class="control-label col-sm-2" for="passwordRe">Retype Password:</label>
				<div class="col-sm-4">
					<input name="passwordRe" id="passwordRe" class="form-control"
						type="text" placeholder="" maxlength="50" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="role">Role:</label>
				<div class="col-sm-4">
				<select name="role" id="role" class="form-control">
				<option>Please select the user's Role</option>
				<option value="admin">Admin</option>
				<option value="user">User</option>
				</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="firstName">First Name:</label>
				<div class="col-sm-4">
					<input value="<%=user.getFirstName() %>"  name="firstName" id="firstName" class="form-control"
						type="text" placeholder="" maxlength="50" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="lastName">Last Name:</label>
				<div class="col-sm-4">
					<input name="lastName" id="lastName" class="form-control"
						type="text" placeholder="" maxlength="50" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="phone">Phone:</label>
				<div class="col-sm-4">
					<input name="phone" id="phone" class="form-control"
						type="text" placeholder="" maxlength="50" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="address">Address:</label>
				<div class="col-sm-4">
					<input name="address" id="address" class="form-control"
						type="text" placeholder="" maxlength="50" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="city">City:</label>
				<div class="col-sm-4">
					<input name="city" id="city" class="form-control"
						type="text" placeholder="" maxlength="50" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="province">Province:</label>
				<div class="col-sm-4">
				<select name="province" id="province" class="form-control">
				<option>Please select a Province</option>
				<option value="QC">QC</option>
				<option value="ON">ON</option>
				</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="zipcode">Zipcode:</label>
				<div class="col-sm-4">
					<input name="zipcode" id="zipcode" class="form-control"
						type="text" placeholder="" maxlength="50" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2"></label>
				<div class="col-sm-4">
					<button type="submit" class="btn btn-primary">Add/Edit User</button>
				</div>
			</div>
		</form>
		<%} %>
        
<!--         END OF THE BODY CONTENT-->
        
      
        <hr />
        
        <jsp:include page="Shared/_footer.jsp"></jsp:include>
    </div>

<jsp:include page="Shared/_scripts_bundle.jsp"></jsp:include>
</body>
</html>
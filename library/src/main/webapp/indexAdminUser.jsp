<!DOCTYPE html>
<%@page import="com.jac.web.controller.Globals"%>
<%@page import="com.jac.web.model.User"%>
<%@ page import="java.util.ArrayList"%>
<html>
<jsp:include page="Shared/_head.jsp"></jsp:include>
<body>
	<jsp:include page="Shared/_navbarAdmin.jsp"></jsp:include>


	<br />
	<br />
	<div class="container body-content" style="margin-top: 45px">


		<!--         THE BODY CONTENT STARTS HERE -->

		<%
			if (!Globals.IsAdmin) {
		%>
		<jsp:forward page="welcome.jsp" />
		<%
			}
		%>


		<h1>User Management</h1>
		<%
			ArrayList<User> usersActiveList = (ArrayList<User>) request.getAttribute("usersActiveList");
		ArrayList<User> usersUnActiveList = (ArrayList<User>) request.getAttribute("usersUnActiveList");
		%>

		<div class="container">			
			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#Active">Active</a></li>
				<li><a data-toggle="tab" href="#UnActive">UnActive</a></li>
			</ul>

			<div class="tab-content">
				<div id="Active" class="tab-pane fade in active">
					<div class="input-group col-sm-4">
						<input id="myActiveInput" type="text" class="form-control"
							placeholder="Search by anything" name="search">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>

					<div class="panel">
						<div class="panel-heading">
							<a href="addEditUser.jsp"><button type="button"
									class="btn btn-primary">New User</button></a>
						</div>
						<div class="panel-body">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>UserID</th>
										<th>Username</th>
										<th>Phone</th>
										<th>Address</th>
										<th>City</th>
										<th>Province</th>
										<th>ZipCode</th>
									</tr>
								</thead>
								<tbody id="ActiveList">
									<%
										for (User tempUser : usersActiveList) {
									%>
									<tr>
										<td><%=tempUser.getID()%></td>
										<td><%=tempUser.getUsername()%></td>
										<td><%=tempUser.getPhone()%></td>
										<td><%=tempUser.getAddress()%></td>
										<td><%=tempUser.getCity()%></td>
										<td><%=tempUser.getProvince()%></td>
										<td><%=tempUser.getZip()%></td>
										<td><button onclick="disableUser(this)" type="button"
												class="btn btn-danger">Disable</button>|<a
											href="<%=Globals.RootPath%>/GoToEditUser?id=<%=tempUser.getID()%>"><button
													type="button" class="btn btn-primary">Edit</button></a></td>
									</tr>
									<%
										}
									%>

								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div id="UnActive" class="tab-pane fade">
					<div class="input-group col-sm-4">
						<input id="myUnActiveInput" type="text" class="form-control"
							placeholder="Search by anything" name="search">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
					<div class="panel">
						<div class="panel-heading"></div>
						<div class="panel-body">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>UserID</th>
										<th>Username</th>
										<th>Phone</th>
										<th>Address</th>
										<th>City</th>
										<th>Province</th>
										<th>ZipCode</th>
									</tr>
								</thead>
								<tbody id="UnActiveList">
									<%
										for (User tempUser : usersUnActiveList) {
									%>
									<tr>
										<td><%=tempUser.getID()%></td>
										<td><%=tempUser.getUsername()%></td>
										<td><%=tempUser.getPhone()%></td>
										<td><%=tempUser.getAddress()%></td>
										<td><%=tempUser.getCity()%></td>
										<td><%=tempUser.getProvince()%></td>
										<td><%=tempUser.getZip()%></td>
										<td><button onclick="enableUser(this)" type="button"
												class="btn btn-danger">Enable</button>|<a
											href="GoToEditUser?id=<%=tempUser.getID()%>"><button
													type="button" class="btn btn-primary">Edit</button></a></td>
									</tr>
									<%
										}
									%>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--         END OF THE BODY CONTENT-->


		<hr />

		<jsp:include page="Shared/_footer.jsp"></jsp:include>
	</div>

	<jsp:include page="Shared/_scripts_bundle.jsp"></jsp:include>
	<script>
		function disableUser(btn) {
			var trElement = $(btn).parent().parent();
			var id = trElement.children("td:eq(0)").text();
			var name = trElement.children("td:eq(1)").text();	
			var href=window.location.href;
			if (confirm("Do you want to Disable the User id: " + id + ", Username:" + name)) {				
				$.post("DisableUser", {
					ID : id
				}, function(data, status) {
					alert(data);
					if (data!="Failure") {
						//trElement.remove();
						window.location.assign(href);
					}
				});
			}
		}
		
		function enableUser(btn) {
			var trElement = $(btn).parent().parent();
			var id = trElement.children("td:eq(0)").text();
			var name = trElement.children("td:eq(1)").text();	
			var href=window.location.href;
			if (confirm("Do you want to Active the User id: " + id + ", Username:" + name)) {				
				$.post("EnableUser", {
					ID : id
				}, function(data, status) {
					alert(data);
					if (status.toLowerCase() == "success") {
						//trElement.remove();
						window.location.assign(href);
					}
				});
			}
		}
		
		$(document).ready(function(){
			  $("#myActiveInput").on("keyup", function() {
			    var value = $(this).val().toLowerCase();
			    $("#ActiveList tr").filter(function() {
			      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			    });
			  });
			  
			  $("#myUnActiveInput").on("keyup", function() {
				    var value = $(this).val().toLowerCase();
				    $("#UnActiveList tr").filter(function() {
				      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
				    });
				  });
			});
	</script>
</body>

</html>
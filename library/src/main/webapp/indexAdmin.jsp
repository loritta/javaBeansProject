<!DOCTYPE html>
<%@page import="com.jac.web.controller.Globals"%>
<%@page import="com.jac.web.model.Book"%>
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


		<h1>Books Management</h1>
		
		<%
			ArrayList<Book> booksList = (ArrayList<Book>) request.getAttribute("booksList");
		%>
		<div class="panel">
			<div class="panel-heading">
				<a href="addEditBook.jsp"><button type="button" class="btn btn-primary">New Book</button></a>
			</div>			
			<div class="input-group col-sm-4" style="margin-left: 16px;">
				<input id="myInput" type="text" class="form-control" placeholder="Search by anything"
					name="search">
				<div class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</div>			
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Book ID</th>
							<th>Name</th>
							<th>Author</th>
							<th>PublishYear</th>
							<th>Operation</th>
						</tr>
					</thead>
					<tbody id="myBookTable">
						<%
							for (Book tempBook : booksList) {
						%>
						<tr>
							<td><%=tempBook.getId()%></td>
							<td><%=tempBook.getTitle()%></td>
							<td><%=tempBook.getAuthor()%></td>
							<td><%=tempBook.getPublishYear()%></td>
							<td><button onclick="deleteBook(this)" type="button"
									class="btn btn-danger">Del</button>|<a href="GoToEditBook?id=<%=tempBook.getId()%>"><button type="button" class="btn btn-primary">Edit</button></a> 
									</td>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>				
			</div>
		</div>




		<!--         END OF THE BODY CONTENT-->


		<hr />

		<jsp:include page="Shared/_footer.jsp"></jsp:include>
	</div>

	<jsp:include page="Shared/_scripts_bundle.jsp"></jsp:include>
	<script>
		function deleteBook(btn) {
			var trElement = $(btn).parent().parent();
			var id = trElement.children("td:eq(0)").text();
			var name = trElement.children("td:eq(1)").text();
			var author = trElement.children("td:eq(2)").text();
			var publishyear = trElement.children("td:eq(3)").text();
			var href=window.location.href;
			if (confirm("Do you want to delete the book id: " + id + ", Name: " + name)) {
				
				$.post("DeleteBook", {
					ID : id
				}, function(data, status) {					
					alert(data);
					if (data != "Failure") {
						//trElement.remove();
						window.location.assign(href);
					}
				});
			}
		}
		
		$(document).ready(function(){
			  $("#myInput").on("keyup", function() {
			    var value = $(this).val().toLowerCase();
			    $("#myBookTable tr").filter(function() {
			      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			    });
			  });
			});
	</script>
</body>

</html>

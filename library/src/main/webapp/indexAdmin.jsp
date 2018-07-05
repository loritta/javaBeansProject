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
				<button type="button" class="btn btn-primary">New Books</button>
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
					<tbody>
						<%
							for (Book tempBook : booksList) {
						%>
						<tr>
							<td><%=tempBook.getId()%></td>
							<td><%=tempBook.getTitle()%></td>
							<td><%=tempBook.getAuthor()%></td>
							<td><%=tempBook.getPublishYear()%></td>
							<td><button onclick="deleteBook(this)" type="button"
									class="btn btn-danger">Del</button></td>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>
				<a href="<%=Globals.RootPath%>/GoToEditUser?id=1">
					<button type="button" class="btn btn-warning">EditUser</button>
				</a> <a href=""> go to Edit Book</a> <a href="addEditUser.jsp"><button
						type="button" class="btn btn-warning">New User</button></a> <a href="">
					go to Add Book</a>
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
			var txt;
			if (confirm("Do you want to delete the book id:" + id + "," + name)) {
				
				$.post("<%=Globals.RootPath%>/DeleteBook", {
					ID : id
				}, function(data, status) {
					alert(data);
					if (status.toLowerCase() == "success") {
						trElement.remove();
					}
				});
			}
		}
	</script>
</body>

</html>

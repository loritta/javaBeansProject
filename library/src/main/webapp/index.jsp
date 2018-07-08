<!DOCTYPE html>
<%@page import="com.jac.web.controller.Globals"%>
<%@page import="com.jac.web.model.Book"%>
<%@ page import="java.util.ArrayList"%>
<html>
<jsp:include page="Shared/_head.jsp"></jsp:include>

<body>
	<jsp:include page="Shared/_navbarUser.jsp"></jsp:include>


	<br />
	<br />
	<div class="container body-content" style="margin-top: 45px">


		<!--         THE BODY CONTENT STARTS HERE -->

		<%
			ArrayList<Book> booksList = (ArrayList<Book>) request.getAttribute("booksList");
			String searchString = request.getAttribute("searchString")==null? "" : (String)request.getAttribute("searchString");
		%>
		<h1>List of books</h1>
		<form action="GoToUser" method="post" id="searchBox" name="searchBox">
			<div class="input-group col-sm-4" style="margin: 10px 0 15px 2px;">
				<input id="search" type="text" class="form-control"
					placeholder="Search by title" name="search">
				<div class="input-group-btn">
					<button id="clean" class="btn btn-danger" type="reset">
						<i class="fa fa-close"></i>
					</button>
					<button class="btn btn-primary" type="submit">
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
		</form>
		

		<%
			if (booksList.size() == 0) {
		%>
		<h4 class="text-danger">No book found!</h4>
		<%
			} else {

				for (Book tempBook : booksList) {
		%>
		<div class="asset-item">
			<div class="card">
				<a href="#"> <img class="card-img-top scaleImg zzz"
					src=<%=tempBook.getPicLink()%> style="height: 270px;"
					title="<%=tempBook.getTitle()%>" alt="<%=tempBook.getTitle()%>" /></a><br />
				<br />
				<div class="card-body">
					<h4 class="card-title">
						<%
							if (tempBook.getTitle().length() <= 34) {
						%>
						<span><%=tempBook.getTitle()%></span>
						<%
							} else {
						%>
						<span><%=tempBook.getTitle().substring(0, 34)%>...</span>
						<%
							}
						%>
					</h4>
					<%-- 					<!--  <p class="card-text"><%=tempBook.getDescription()%></p>--> --%>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item card-list-item"><b>Author: </b><%=tempBook.getAuthor()%></li>
					<li class="list-group-item card-list-item"><b>Publish
							year: </b><%=tempBook.getPublishYear()%></li>
				</ul>

			</div>
		</div>

		<%
				}
			}
		%>

		<!--         END OF THE BODY CONTENT-->

		<br />

		<jsp:include page="Shared/_footer.jsp"></jsp:include>
	</div>

	<jsp:include page="Shared/_scripts_bundle.jsp"></jsp:include>
		<script>
		$(document).ready(function(){
			$('#search').val("<%=searchString%>");
			  $("#clean").on("click", function() {
				  $('#search').val("");
			  });
			});
	</script>
</body>

</html>
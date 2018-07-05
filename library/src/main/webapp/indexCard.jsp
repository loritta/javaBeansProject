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


		<h1>List of books</h1>
		<%
			ArrayList<Book> booksList = (ArrayList<Book>) request.getAttribute("booksList");
		%>

		<!-- 		<div style="display: inline-block; margin: 0 auto"> -->
		<%
			for (Book tempBook : booksList) {
		%>
		 			<div class="asset-item"> 
						<a href="#">
							<div>
								<div style="text-align: center">
									<h4>
										<%if (tempBook.getTitle().length()<= 34) {%> <span><%=tempBook.getTitle()%></span><% } else {
											%> <span><%=tempBook.getTitle().substring(0, 34)%>...</span> <%}%>
									</h4>
								</div>
								<div style="text-align: center">
									<img src=<%=tempBook.getPicLink()%> style="height: 230px;" title="<%=tempBook.getTitle()%>"
										alt="<%=tempBook.getTitle()%>" /><br /> <br />
								</div>
							</div>
						</a>
					</div> 
			<%}%>
 		</div> 

<div class="card" style="width: 20rem;">
  <img class="card-img-top" src="..." alt="Card image cap">
  <div class="card-body">
    <h4 class="card-title">Card title</h4>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Cras justo odio</li>
    <li class="list-group-item">Dapibus ac facilisis in</li>
    <li class="list-group-item">Vestibulum at eros</li>
  </ul>
  <div class="card-body">
    <a href="#" class="card-link">Card link</a>
    <a href="#" class="card-link">Another link</a>
  </div>
</div>



		<!--         END OF THE BODY CONTENT-->


		<hr />

		<jsp:include page="Shared/_footer.jsp"></jsp:include>
	</div>

	<jsp:include page="Shared/_scripts_bundle.jsp"></jsp:include>
</body>

</html>

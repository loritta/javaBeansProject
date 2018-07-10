<%@page import="com.jac.web.controller.*"%>
<%@page import="com.jac.web.model.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:include page="Shared/_head.jsp"></jsp:include>
<html>
<body>
	<jsp:include page="Shared/_navbarAdmin.jsp"></jsp:include>
	<br />
	<br />

	<div class="container body-content" style="margin-top: 45px">

		<%
			if (request.getAttribute("book") == null) {
		%>
		<h1>Add Book</h1>
		<form class="form-horizontal" action="SaveBook" method="post"
			enctype="multipart/form-data">
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">Title:</label>
				<div class="col-sm-4">
					<input name="title" id="title" class="form-control" type="text"
						placeholder="" maxlength="50" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="author">Author</label>
				<div class="col-sm-4">
					<input name="author" id="author" class="form-control" type="text"
						placeholder="" maxlength="50" required>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="publicshYear">Publication
					Year:</label>
				<div class="col-sm-4">
					<input name="publicshYear" id="publicshYear" class="form-control"
						type="text" placeholder="xxxx" maxlength="50" required
						pattern="^\d{4}$">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="picLink">Book
					Photo:</label>
				<div class="col-sm-4">
					<input type="file" class="form-control-file" name="picLink"  />
				</div>

			</div>

			<br />
			<div class="form-group">
				<label class="col-sm-2"></label>
				<div class="col-sm-4">
					<button type="submit" class="btn btn-primary">Save</button>&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-light" onClick="history.go(-1);">Go Back</button>
				</div>
			</div>
			<input type="hidden"  id="id" name="id" readonly value="0">
		</form>

		<%
			} else {
				Book book = (Book) request.getAttribute("book");
		%>

		<h1>Edit Book</h1>
		<form class="form-horizontal" action="SaveBook" method="post"
			enctype="multipart/form-data">
			<input type="hidden" id="id" name="id" readonly
				value="<%=book.getId()%>">
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">Title:</label>
				<div class="col-sm-4">
					<input name="title" id="title" class="form-control"
						value="<%=book.getTitle()%>" type="text" placeholder=""
						maxlength="50" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="author">Author</label>
				<div class="col-sm-4">
					<input name="author" id="author" class="form-control"
						value="<%=book.getAuthor()%>" type="text" placeholder=""
						maxlength="50" required>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="publicshYear">Publication
					Year:</label>
				<div class="col-sm-4">
					<input name="publicshYear" id="publicshYear" class="form-control"
						value="<%=book.getPublishYear()%>" type="text" placeholder="xxxx"
						maxlength="50" required pattern="^\d{4}$">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="picLink">Book
					Photo:</label>
				<div class="col-sm-4">
					<input type="file" class="form-control-file" name="picLink" />
				</div>

			</div>

			<div class="form-group">
				<label class="col-sm-2"></label>
				<div class="col-sm-4">
					<button type="submit" class="btn btn-primary">Save</button>&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-light" onClick="history.go(-1);">Go Back</button>
				</div>
			</div>
		</form>

		<%}%>
		<br> <br> <br>
		
		<hr />

		<jsp:include page="Shared/_footer.jsp"></jsp:include>
	</div>

	<jsp:include page="Shared/_scripts_bundle.jsp"></jsp:include>
</body>
</html>
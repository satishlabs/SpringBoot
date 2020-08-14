<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>JLC Bookstore</title>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="card-header">
		<h2 class="text-center">Welcome to JLC BookStore</h2>
		<h4 class="text-center">Best Books and Videos</h4>
	</div>
	<br />
	<br />
	<div class="container">
		<table class="table table-striped table-bordered"
			style="font-size: 20; font-weight: bold;">
			<tr>
				<th>Book Id</th>
				<th>Book Name</th>
				<th>Author</th>
				<th>Price</th>
				<th>Category</th>
				<th>Publications</th>
				<th colspan="2" align="center"><form:form
						action="addEditBookForm">
						<input type="hidden" name="bookId" value="0" />
						<input type="submit" value="Add New Book"
							class="btn btn-primary btn-lg">
					</form:form></th>
			</tr>
			<c:forEach var="mybook" items="${MyBookList}">
				<tr>
					<td><a href="viewBook?bookId=${mybook.bid }"> ${mybook.bid }
					</a></td>
					<td>${mybook.bname }</td>
					<td>${mybook.author }</td>
					<td>${mybook.price }</td>
					<td>${mybook.category }</td>
					<td>${mybook.pub }</td>
					<td><form:form action="addEditBookForm">
							<input type="hidden" name="bookId" value="${mybook.bid}">
							<input type="submit" value="Edit" class="btn btn-primary btn-lg">
						</form:form></td>
					<td><form:form action="deleteBook">
							<input type="hidden" name="bookId" value="${mybook.bid }">
							<input type="submit" value="Delete" class="btn btn-danger btn-lg" />
						</form:form></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
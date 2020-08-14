<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Satish Book Store</title>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="card">
		<c:import url="myheader.jsp"></c:import>
	</div>
	<div class="card">
		<div class="card-body">
			<c:import url="mymenu.jsp"></c:import>
			<div>
				<hr />
				<h2>Display List of books here</h2>
			</div>
		</div>
	</div>
	<c:import url="myfooter.jsp"></c:import>
</body>
</html>
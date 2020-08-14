<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Satish Book Store</title>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"> 
</head>
<body>
	<div class="card">
		<c:import url="myheader.jsp"/>
	</div>
	<div class="card">
		<div class="card-body">
			<c:import url="mymenu.jsp"/>
			
			<div class="container">
				<hr>
				<h2 align="center">You are not authorized to access this page</h2> 
			</div>
		</div>
	</div>
	<c:import url="myfooter.jsp"></c:import>
</body>
</html>
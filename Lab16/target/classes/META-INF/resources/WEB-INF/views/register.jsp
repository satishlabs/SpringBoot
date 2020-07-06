<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib  prefix="form"  uri="http://www.springframework.org/tags/form"%> 
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
	<div class="card-body" align="center">
		<hr>
		<div class="container">
			<h2 align="center">
				<c:if test="${param.error != null}">
					<font color="red" size="5">Invalid username and password</font>
				</c:if>
				
				<c:if test="${param.logout != null}">
					<font color="red" size="5">You have logged out successfully!!</font>
				</c:if>
			</h2>
		</div>
		<div class="container">
			<form:form action="registerMyUser" method="post" modelAttribute="myuser">
				<table class="table">
					<tr>
						<td align="center" colspan="2">
						<h2>User Registration Form</h2>
						</td>
					</tr>
					<tr>
					<td>Username</td>
					<td><form:input path="username" class="form-control form-control-lg"/></td>
					<td><form:errors path="username"/></td>
					</tr>
					<tr>
					<td>Password</td>
					<td><form:input path="password" class="form-control form-control-lg"/></td>
					<td><form:errors path="password"/></td>
					</tr>
					<tr>
					<td>First Name</td>
					<td><form:input path="firstname" class="form-control form-control-lg"/></td>
					<td><form:errors path="firstname"/></td>
					</tr>
					<tr>
					<td>Last Name</td>
					<td><form:input path="lastname" class="form-control form-control-lg"/></td>
					<td><form:errors path="lastname"/></td>
					</tr>
					<tr>
					<td>Email</td>
					<td><form:input path="email" class="form-control form-control-lg"/></td>
					<td><form:errors path="email"/></td>
					</tr>
					<tr>
					<td>Phone</td>
					<td><form:input path="phone" class="form-control form-control-lg"/></td>
					<td><form:errors path="phone"/></td>
					</tr>
					<tr>
					<td align="center" colspan="2">
					<input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}" /> 
					<input type="submit" value=" Register Bow" class="btn btn-primary btn-lg"> 
					</td>
					</tr>
				</table>
			</form:form>
		</div>
		<div class="container"> <h2>  
		<b> <a href='<c:url value="login"/>'>  Already Registered Login Here </a> </b></h2> </div> 
	</div>
</div>
<c:import url="myfooter.jsp"/>
</body>
</html>
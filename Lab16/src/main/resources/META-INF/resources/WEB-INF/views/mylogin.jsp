<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Satish Book Store</title>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="card">
		<c:import url="myheader.jsp" />
	</div>
	<div class="card">
		<div class="card-body" align="center">
			<div class="container-md">
				<h2 align="center">
					<c:if test="${param.error !=null}">
						<font color="red" size="5">Invalid username and password</font>
					</c:if>
					<c:if test="${param.logout != null }">
						<font color="red" size="5">You have logged out
							sccessfully!!</font>
					</c:if>
				</h2>
			</div>
			<div class="container from-group">
				<form name="loginForm" action="<c:url value='/login'/>"
					method="POST">
					<table class="table">
						<tr>
							<td align="center" colspan="2">
								<h2>User Login Form</h2>
							</td>
						</tr>
						<tr> 
						<td><label for="myusername"> Username </label></td> 
						<td><input type='text' name='username'  id="myusername" class="form-control formcontrol-lg"> 
						</td> 
						</tr> 
						<tr> 
						<td>Password</td> 
						<td><input type='password' name='mypassword'  class="form-control form-control-lg" /> 
						</td>
						</tr>
						<tr>
							<td align="center" colspan="2"> 
							<input type=hidden  name="${_csrf.parameterName}" value="${_csrf.token}" /> 
							<input type="submit" value="Login Now" class="btn btn-primary btn-lg"> 
							</td> 
						</tr>
					</table>
				</form>
			</div>
			<div class="container">
				<h2>
					<b> <a href='<c:url value="showRegister"/>'> New User
							Register Here </a>
					</b>
				</h2>
			</div>
		</div>
	</div>
</body>
</html>
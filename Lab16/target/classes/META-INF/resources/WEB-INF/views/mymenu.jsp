<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div class="container" align="right">
	<h2>
		<a href="/"> Home</a> | Welcome :
		${pageContext.request.userPrincipal.name} ${MyRoles}
		<sec:authorize access="!isAuthenticated()">
		|<a href="login">Login</a>
		|<a href="showRegister">Register</a>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
		| <a href="logout">Logout</a>
		</sec:authorize>
	</h2>
</div>
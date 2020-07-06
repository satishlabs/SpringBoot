<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> 
<div class="container" align="right">
<h2>
	|<a href="<c:url value='/'/>"> Home</a> 
	| Welcome : ${pageContext.request.userPrincipal.name}  
	| <a href="<c:url value='logout'/>">  Logout  </a> 
</h2>
</div>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- taglib de jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!-- taglib de spring security -->
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>

<s:authentication property="authorities" var="listeRoles" />
		<ul>
			<c:forEach items="${listeRoles}" var="role">
				<li>${role.authority}</li>
			</c:forEach>

		</ul>


<h1>Coucou</h1>
<a href="${pageContext.request.contextPath}/client/test/" >test client</a>
<a href="${pageContext.request.contextPath}/managerproduit/test/" >test produit</a>

</body>
</html>
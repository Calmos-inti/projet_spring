<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- taglib de jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!-- taglib de spring security -->
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>test</h1>


<s:authentication property="authorities" var="listeRoles" />
		<ul>
			<c:forEach items="${listeRoles}" var="role">
				<li>${role.authority}</li>
			</c:forEach>

		</ul>


<a href="${pageContext.request.contextPath}/client/test/" >test client</a>
<a href="${pageContext.request.contextPath}/managerproduit/test/" >test produit</a>


</body>
</html>
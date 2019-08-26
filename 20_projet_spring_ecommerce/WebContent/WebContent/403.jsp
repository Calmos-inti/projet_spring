<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> HTTP 403 - Access denied</h1>

<s:authorize access="hasRole('ROLE_USER')">

<h2>You don't have permission to perform this action</h2>

<h3> Please Login as an Admin 
<a href="<c:url value='/login.jsp'/>">Login</a>

</h3>


</s:authorize>

</body>
</html>
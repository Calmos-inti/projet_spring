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

	<h1>Page index</h1>
	<br />
	<!-- Liens pour les tests (seront supprimés quand les tests seront finis) -->
	<h3>Test clients :</h3>
	<a href="${pageContext.request.contextPath}/client/test/">test
		Client</a>
	<br />
	<h3>Test manager produit :</h3>
	<a href="${pageContext.request.contextPath}/produit/test/">test
		produit</a>
	<br />
	<h3>Test manager categorie :</h3>
	<a href="${pageContext.request.contextPath}/categorie/test/">test
		categorie</a>
	<br />
	<hr />
	<br />
	<!-- Liens vers l'accueil (sera changé en redirection quant les tests seront finis) -->
	<h3>Aller à l'accueil :</h3>
	<a href="${pageContext.request.contextPath}/accueil">accueil</a>

	<hr />
	<br />
	
	<h1>tests Clément</h1>
	<table>
		<tr>
			<td align="left">Partie Categorie</td>

			<td align="right"><a href="categorie/liste">Lien</a>
			</td>
		</tr>
		<tr>
			<td align="left">Partie Produit</td>

			<td align="right"><a href="produit/liste">Lien</a> 
			</td>
		</tr>
	</table>
	
	
	<hr />
	<br />
	
	<h3>login :</h3>
	<a href="${pageContext.request.contextPath}/login.jsp">login</a>
	
</body>
</html>
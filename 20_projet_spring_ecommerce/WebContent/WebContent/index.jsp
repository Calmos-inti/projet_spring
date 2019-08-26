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
	<a href="${pageContext.request.contextPath}/client/test/">click 1</a>
	<br />
	<h3>Test manager produit :</h3>
	<a href="${pageContext.request.contextPath}/produit/test/">click 3</a>
	<br />
	<h3>Test manager categorie :</h3>
	<a href="${pageContext.request.contextPath}/categorie/test/">click 2</a>
	<br />
	<h3>test lignePanier :</h3>
	<a href="${pageContext.request.contextPath}/ligne_panier/test">click 4</a>
	<br />
	<h3>test commandes :</h3>
	<a href="${pageContext.request.contextPath}/commande/test">click 5</a>
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
	<br/>
	<hr/>
	
	
	<h3>login :</h3>
	<a href="${pageContext.request.contextPath}/login.jsp">login</a>
	<br/>
	<hr/>
	<h3>test</h3>
	<a href="${pageContext.request.contextPath}/test33">login</a>
	
	
</body>
</html>
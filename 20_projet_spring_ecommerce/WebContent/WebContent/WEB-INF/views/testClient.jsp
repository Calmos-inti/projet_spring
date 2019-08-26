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

<!-- Page test � supprimer quand tout est OK -->

<h1>On est pass� par la m�thode 'tester()' de ClientController</h1>

<h1>Test effectu�</h1>
<ul>
  <li>Ajout de 4 clients et 4 users dans la bdd</li>
  <li>Roles par d�faut ajout� lors de la cr�ation : 'ROLE_CLIENT' pour Client et 'ROLE_CLIENT' + 'ROLE_PRODUIT' pour users</li>
  <li>Tes d'affichage de m�thode getAll sur la console Eclipse OK</li>
  <li>Tes d'affichage de m�thode getById sur la console Eclipse OK</li>
  <li>Suppression du client (id=2) et user (id=6) --> leurs r�les sont biens �galement effac�s de la bdd</li>
  <li>Modification du client (id=3) et user (id=7)</li>
</ul>

<a href="${pageContext.request.contextPath}/index.jsp" >Retour � index</a>



</body>
</html>
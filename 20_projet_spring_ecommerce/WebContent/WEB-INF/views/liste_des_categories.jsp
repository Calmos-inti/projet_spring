<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des catégories</title>
</head>
<body>

<div align="center">
		<h1 style="background-color: lightgreen; color: darkgreen">Liste
			des catégories</h1>

		<table cellspacing="0" cellpadding="6" width="60%">
			
			<tr>
				<td colspan="6" align="center">
					<a href="${pageContext.request.contextPath}/addCategorie" style="background-color: lightblue;">ajouter une catégorie</a>
				</td>
			</tr>
			<tr bgcolor="grey" style="color: white;">
				<th>Id</th>
				<th>Nom</th>
				<th>Photo</th>
				<th>Description</th>
				<th colspan="2">Operations</th>
			</tr>

			<!-- attribut_liste_foncts = listeFonctionnaires -->
			<c:forEach items="${liste_categories}" var="fonct">
				<tr bgcolor="lightyellow">
					<td><b>${fonct.idCategorie}</b></td>
					<td>${fonct.nomCategorie}</td>
					<td>${fonct.photo}</td>
					<td>${fonct.description}</td>

					<!-- ${pageContext.request.contextPath} = http://localhost:8080/09_advanced_framework_spring_mvc -->
					<td><a
						href="${pageContext.request.contextPath}/categorie/delete/${fonct.idCategorie}">Supprimer</a>
					</td>
					
		
					<td>
						<a href="${pageContext.request.contextPath}/categorie/updateform?fonctId=${fonct.idCategorie}">Modifier</a>
					</td>				
					
				</tr>
				
			
			</c:forEach>

		</table>


	</div>

</body>
</html>
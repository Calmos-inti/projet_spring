<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
		<h1 style="background-color: lightbrown; color: orange">Liste
			des produits</h1>

		<table cellspacing="0" cellpadding="6" width="60%">
			
			<tr>
				<td colspan="8" align="center">
					<a href="${pageContext.request.contextPath}/addProduit" style="background-color: goldenrod;">ajouter un produit</a>
				</td>
			</tr>
			<tr bgcolor="grey" style="color: white;">
				<th>Id</th>
				<th>Désignation</th>
				<th>Description</th>
				<th>Prix</th>
				<th>Quantité</th>
				<th>Photo</th>
				<th colspan="2">Operations</th>
			</tr>

			<!-- attribut_liste_foncts = listeFonctionnaires -->
			<c:forEach items="${liste_produits}" var="fonct">
				<tr bgcolor="lightyellow">
					<td><b>${fonct.idProduit}</b></td>
					<td>${fonct.designation}</td>
					<td>${fonct.description}</td>
					<td>${fonct.prix}</td>
					<td>${fonct.quantite}</td>
					<td>${fonct.photo}</td>
					<!-- ${pageContext.request.contextPath} = http://localhost:8080/09_advanced_framework_spring_mvc -->
					<td><a
						href="${pageContext.request.contextPath}/produit/delete/${fonct.idProduit}">Supprimer</a>
					</td>
					
		
					<td>
						<a href="${pageContext.request.contextPath}/produit/updateform?fonctId=${fonct.idProduit}">Modifier</a>
					</td>				
					
				</tr>
				
			
			</c:forEach>

		</table>


	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div>
		<h1 style="background-color: lightgreen; color: darkgreen">Association d'un produit à une catégorie</h1>
		
		<!-- Formulaire -->
		
		<form:form modelAttribute="produitAssoCommand" action="${pageContext.request.contextPath}/produit/associate" method="post">
			
			<table width="100%" align="center">
				
				<tr>
				
					<td></td>
					<td>
	<form:hidden path="idProduit"/>
					</td>
				
				</tr>
				
				<!-- champ nom -->
				<tr>
				
					<td> <form:label path="categorie"> Catégorie :</form:label> </td>
					<td>
						<form:input path="categorie"/>
					</td>
				
				</tr>
				
					<tr>
					<td colspan="3">
						<input type="submit" value="Associer ce produit à cette catégorie"/>
					</td>
				</tr>
			</table>
			
		</form:form>

	</div>
	
	
	<br/>
		<br/>
			<br/>
				<br/>
					<br/>
	<div>
		<h1 style="background-color: lightgreen; color: darkgreen">Liste
			des catégories existantes</h1>

		<table cellspacing="0" cellpadding="6" width="60%">
			
			<tr bgcolor="grey" style="color: white;">
				<th>Id</th>
				<th>Nom</th>
			</tr>

	
			<c:forEach items="${liste_categories}" var="fonct">
				<tr bgcolor="lightyellow">
					<td><b>${fonct.idCategorie}</b></td>
					<td>${fonct.nomCategorie}</td>
				</tr>
		</c:forEach>

		</table>


	</div>
	




</body>
</html>
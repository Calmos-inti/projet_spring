<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div>
		<h1 style="background-color: lightgreen; color: darkgreen">Modification d'une catégorie</h1>
		
		<!-- Formulaire -->
		
		<form:form modelAttribute="categorieUpCommand" action="${pageContext.request.contextPath}/categorie/update" method="post">
			
			<table width="100%" align="center">
				
				<tr>
				
					<td></td>
					<td>
						<form:hidden path="idCategorie"/>
					</td>
				
				</tr>
				
				<!-- champ nom -->
				<tr>
				
					<td> <form:label path="nomCategorie"> Nom :</form:label> </td>
					<td>
						<form:input path="nomCategorie"/>
					</td>
				
				</tr>
				
				<!-- champ fonction -->
				<tr>
				
					<td> <form:label path="photo"> Photo :</form:label> </td>
					<td>
						<form:input path="photo"/>
					</td>
				
				</tr>
				
				<!-- champ salaire -->
				<tr>
				
					<td> <form:label path="description"> Description :</form:label> </td>
					<td>
						<form:input path="description"/>
					</td>
				
				</tr>
				
				<!-- bouton -->
				
				<tr>
					<td colspan="2">
						<input type="submit" value="Modifier la catégorie"/>
					</td>
				</tr>
			
			</table>
			
		</form:form>

	</div>


</body>
</html>
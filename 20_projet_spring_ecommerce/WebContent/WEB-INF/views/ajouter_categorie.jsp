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
		<h1 style="background-color: lightgreen; color: darkgreen">Ajout d'une nouvelle catégorie</h1>
		<form:form modelAttribute="categorieCommand" enctype="multipart/form-data" action="categorie/add" method="post" >
			
			<table width="100%">
				
				<tr>
				
					<td> <form:label path="nomCategorie"> Nom :</form:label> </td>
					<td>
						<form:input path="nomCategorie"/>
					</td>
				
				</tr>
				
				<tr>
				
   		<td> <form:label for="photo" path="photo"> Photo :</form:label> </td>
					<td>
						<form:input type="file" path="photo"/>
					</td>
					
				
				</tr>
				
				<tr>
				
					<td> <form:label path="description"> Description :</form:label> </td>
					<td>
						<form:input path="description"/>
					</td>
				
				</tr>
				
				<!-- bouton -->
				
				<tr>
					<td colspan="3">
						<input type="submit" value="Ajouter cette nouvelle catégorie"/>
					</td>
				</tr>
			
			</table>
		</form:form>
	</div>

</body>
</html>
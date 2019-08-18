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
		<h1 style="background-color: lightorange; color: darkblue">Ajout d'un nouveau produit</h1>
		<form:form modelAttribute="produitCommand" action="produit/add" method="post">
			
			<table width="100%">
				
				<tr>
				
					<td> <form:label path="designation"> Designation :</form:label> </td>
					<td>
						<form:input path="designation"/>
					</td>
				
				</tr>
				
				<tr>
				
   		<td> <form:label path="description"> Description :</form:label> </td>
					<td>
						<form:input path="description"/>
					</td>
					
				
				</tr>
				
				<tr>
				
					<td> <form:label path="prix"> Prix :</form:label> </td>
					<td>
						<form:input path="prix"/>
					</td>
				
				</tr>
				
				<tr>
				
					<td> <form:label path="quantite"> Quantité :</form:label> </td>
					<td>
						<form:input path="quantite"/>
					</td>
				
				</tr>
				<tr>
				<td></td>
					<td> <form:hidden path="selection"/> 
					</td>
				
				</tr>
				<tr>
				
					<td> <form:label path="photo"> Photo :</form:label> </td>
					<td>
						<form:input path="photo"/>
					</td>
				
				</tr>
				
				<!-- bouton -->
				
				<tr>
					<td colspan="3">
						<input type="submit" value="Ajouter ce nouveau produit"/>
					</td>
				</tr>
			
			</table>
		</form:form>
	</div>

</body>
</html>
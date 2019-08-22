<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- taglib de jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- taglib de Spring Security -->
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- lib icone : Fontawesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">

<!-- Spécification du chemin de la lib Popper -->
<script
	src="<c:url value="/resources/bootstrap-Litera/js/popper.min.js" />"></script>

<!-- Spécification du chemin de la lib jQuery -->
<script
	src="<c:url value="/resources/bootstrap-Litera/js/jquery-3.4.1.js" />"></script>

<!-- Spécification du chemin la lib js Bootrap à la page -->
<script
	src="<c:url value="/resources/bootstrap-Litera/js/bootstrap.min.js" />"></script>

<!-- Spécification du chemin la lib css Bootrap à la page -->
<link
	href="<c:url value="/resources/bootstrap-Litera/css/bootstrap.min.css" />"
	rel="stylesheet">
</head>
<body>
	<!-- =============== inclusion du header ========================== -->
	<%@ include file="/resources/template/header.jsp"%>
	<!-- ============================================================== -->
	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="col-sm-10 ">
			<br/>
		<div align="center"><h1>
		Administration Manager produits</h1></div>
			<br/>
			<br/>
		
				<!-- =============== inclusion menu gauche ========================== -->
<div class="row">
					<div class="col-2">

						<%@ include file="/resources/template/menu_vertical_gauche.jsp"%>

					</div>
					<div class="col-1"></div>
<div class="col-5" style="background-color:lightgrey" >
<br/>
		<div align="center"><h3 style="color: darkblue">Modification d'une catégorie</h3></div>
		<br/>
		<br/>
		
		<form:form modelAttribute="categorieUpCommand" enctype="multipart/form-data" action="${pageContext.request.contextPath}/categorie/update" method="post">
			
			<table width="60%" align="center" cellpadding="6">
				
				<tr>
				
					<td></td>
					<td>
	<form:hidden path="idCategorie"/>
					</td>
				
				</tr>
				
			
				<tr>
				
					<td colspan="3" align="center"> <form:label path="nomCategorie"> Nom :</form:label> </td>
					<td>
						<form:input path="nomCategorie"/>
					</td>
				
				</tr>
				
				
				<tr>
				
					<td colspan="3" align="center"> <form:label for="photo" path="photo"> Photo :</form:label> </td>
					<td>
						<form:input type="file" path="photo"/>
					</td>
				
				</tr>
				
				
				<tr >
				
					<td colspan="3" align="center"> <form:label path="description"> Description :</form:label> </td>
					<td>
						<form:input path="description"/>
					</td>
				
				</tr>
				
				<!-- bouton -->
				
				<tr>
					<td colspan="3">
						<input type="submit" type="button" class="btn btn-success" value="Modifier cette catégorie"/>
					</td>
				</tr>
			
			</table>
			
		</form:form>

	</div>
			<div class="col-1"></div>
					<div class="col-3">
					
					<p align="center">Mémento : Liste
			des catégories</p>

		<table cellspacing="0" cellpadding="6" width="100%" border="1px">
			<tr bgcolor="grey" style="color: white;">
				<th>Id</th>
				<th>Nom</th>
			</tr>

			<c:forEach items="${liste_categories}" var="fonct">
				<tr bgcolor="white">
					<td><b>${fonct.idCategorie}</b></td>
					<td>${fonct.nomCategorie}</td>
				</tr>
			
			</c:forEach>

		</table>
					</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- taglib de jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- taglib de Spring Security -->
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
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
		<div align="center">
		<h1>
		Liste des catégories</h1></div>
			<br/>
			<br/>
		
				<!-- =============== inclusion menu gauche ========================== -->
<div class="row">
					<div class="col-2">

						<%@ include file="/resources/template/menu_vertical_gauche.jsp"%>

					</div>
<div class="col-10" align="center">
		<table cellspacing="0" cellpadding="10" width="100%">
			
			
			<tr bgcolor="grey" style="color: white;">
				<th>Id</th>
				<th>Nom</th>
				<th>Photo</th>
				<th>Description</th>
				<s:authorize access="hasRole('ROLE_CATEGORIE')"><th colspan="2">Operations</th></s:authorize>
			</tr>

			<!-- attribut_liste_foncts = listeFonctionnaires -->
			<c:forEach items="${liste_categories}" var="fonct">
				<tr bgcolor="lightyellow">
					<td><b>${fonct.idCategorie}</b></td>
					<td>${fonct.nomCategorie}</td>
					<td><img src="${pageContext.request.contextPath}/myImage/imageCategorieDisplay?id=${fonct.photo}"/></td>
					<td>${fonct.description}</td>

					<!-- ${pageContext.request.contextPath} = http://localhost:8080/09_advanced_framework_spring_mvc -->
					 <s:authorize access="hasRole('ROLE_CATEGORIE')"><td><a
						href="${pageContext.request.contextPath}/categorie/delete/${fonct.idCategorie}">Supprimer</a>
					</td></s:authorize>
					
		 <s:authorize access="hasRole('ROLE_CATEGORIE')">
					<td>
						<a href="${pageContext.request.contextPath}/categorie/updateform?fonctId=${fonct.idCategorie}">Modifier</a>
					</td>	</s:authorize>			
					
				</tr>
				
			
			</c:forEach>

		</table>

		<br/>
		<br/>
		<br/>
		
	

	</div>

</div>
	</div>
	</div>
	</div>

	
		<br />
	<br />
	<!-- =============== inlusion du footer ========================== -->
	<%@ include file="/resources/template/footer.jsp"%>
	
</body>
</html>
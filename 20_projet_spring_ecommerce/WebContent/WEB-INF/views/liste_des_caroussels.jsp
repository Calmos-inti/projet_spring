<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- ======================================= LES TAGLIBS ========================================== -->
<!-- taglib de jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- taglib de Spring Security -->
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>

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
	<br />
	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="col-sm-10 ">



				<!-- =============== inclusion Carousel ========================== -->
				<%@ include file="/resources/template/carousel.jsp"%>

				<!-- =============== end carousel ========================== -->


				<!-- =============== inclusion Barre recherche ==================== -->
				<Br />
				<%@ include file="/resources/template/barre_recheche.jsp"%>
				<Br />
				<!-- =============== end Barre recherche ========================== -->

				<div class="row">
					
					<!-- =============== début du Core ========================== -->

					<div class="col-12 ">

						<s:authorize access="hasRole('ROLE_CATEGORIE')">
							<div class="container">
								<div class="row justify-content-center">
									<div class="col-6 ">
										<button
											onclick="location.href='${pageContext.request.contextPath}/addCaroussel'"
											class="btn btn-outline-secondary btn-lg btn-block "
											type="button">Ajouter un caroussel</button>
									</div>
								</div>
							</div>
							<br />
						</s:authorize>


						<div class="container marketing">

		<table cellspacing="0" cellpadding="10" width="100%">
			
			
			<tr bgcolor="grey" style="color: white"; align="center">
				<th>Id</th>
				<th>Photo 1</th>
				<th>Photo 2</th>
				<th>Photo 3</th>
				<th colspan="3">Operations</th>
			</tr>

			<!-- attribut_liste_foncts = listeFonctionnaires -->
			<c:forEach items="${liste_caroussels}" var="fonct">
				<tr bgcolor="lightyellow">
					<td><b>${fonct.idCaroussel}</b></td>
					<td><img src="${pageContext.request.contextPath}/myImage/image1CarousselDisplay?id=${fonct.idCaroussel}" width="250px" height="150px"/></td>
					<td><img src="${pageContext.request.contextPath}/myImage/image2CarousselDisplay?id=${fonct.idCaroussel}" width="250px" height="150px"/></td>
					<td><img src="${pageContext.request.contextPath}/myImage/image3CarousselDisplay?id=${fonct.idCaroussel}" width="250px" height="150px"/></td>
					<!-- ${pageContext.request.contextPath} = http://localhost:8080/09_advanced_framework_spring_mvc -->
						 <s:authorize access="hasRole('ROLE_CATEGORIE')"><td><a
						href="${pageContext.request.contextPath}/caroussel/delete/${fonct.idCaroussel}">Supprimer</a>
					</td></s:authorize>	
							
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
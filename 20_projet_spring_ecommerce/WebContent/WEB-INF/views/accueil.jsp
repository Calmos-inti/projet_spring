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
				<Br/>
				<%@ include file="/resources/template/barre_recheche.jsp"%>
				<Br/>
				<!-- =============== end Barre recherche ========================== -->
				
				<div class="row">
					<!-- =============== inclusion menu gauche ========================== -->

					<div class="col-2">

						<%@ include file="/resources/template/menu_gauche.jsp"%>

					</div>
					<!-- end col-2 -->


					<!-- =============== fin menu gauche ========================== -->


					<!-- =============== début du Core ========================== -->

					<div class="col-10 ">


						<c:if test="${nom_client != null}">
							<div class="row row justify-content-center">
								<div class="col-8 ">
									<div class="alert alert-dismissible alert-success">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<h5 align="center">
											Bienvenue <strong>${nom_client}</strong> !
										</h5>
									</div>
								</div>
							</div>
							<br />
						</c:if>


						<div class="container marketing">

							<div class="row">


								<c:forEach items="${liste_categories}" var="categorie">

									<div class="col-4">
										<svg class="bd-placeholder-img rounded-circle" width="140"
											height="140" xmlns="http://www.w3.org/2000/svg"
											preserveAspectRatio="xMidYMid slice" focusable="false"
											role="img" aria-label="Placeholder: 140x140">
					<title>Placeholder</title><rect width="100%" height="100%"
												fill="#777" />
					<text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>


										<h3>${categorie.nomCategorie}</h3>
										<p>${categorie.description}</p>
										<p>
											<a class="btn btn-info"
												href="${pageContext.request.contextPath}/accueil/liste_produit?idCategorie=${categorie.idCategorie}"
												role="button">Voir tous les articles &raquo;</a>
										</p>
									</div>
									<br />
								</c:forEach>

							</div>
							<!-- end row -->
						</div>
						<!-- end conteneur marketing -->
					</div>
					<!-- end col-8 -->
					<!-- =============== fin du Core ========================== -->

				</div>
				<!-- end row -->
			</div>
			<!-- end col-sm-10 -->
		</div>
		<!-- end row justify-content-center -->
	</div>
	<!-- end container-fluid -->


	<br />
	<br />
	<!-- =============== inlusion du footer ========================== -->
	<%@ include file="/resources/template/footer.jsp"%>

</body>
</html>
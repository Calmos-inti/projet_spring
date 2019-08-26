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
					<!-- =============== inclusion menu gauche ========================== -->

					<div class="col-2">

						<%@ include file="/resources/template/menu_gauche.jsp"%>

					</div>
					<!-- end col-2 -->


					<!-- =============== fin menu gauche ========================== -->


					<!-- =============== début du Core ========================== -->

					<div class="col-10 ">

						<s:authorize access="hasRole('ROLE_CATEGORIE')">
							<div class="container">
								<div class="row justify-content-center">
									<div class="col-6 ">
										<button
											onclick="location.href='${pageContext.request.contextPath}/addCategorie'"
											class="btn btn-outline-secondary btn-lg btn-block "
											type="button">Ajouter une Catégorie</button>
									</div>
								</div>
							</div>
							<br />
						</s:authorize>


						<div class="container marketing">

							<div class="row">


								<c:forEach items="${liste_categories}" var="categorie">

									<div class="col-4">
										<div class="card" style="margin-bottom: 25px">
											<div class="card-body">
												<img class=""
													src="${pageContext.request.contextPath}/myImage/imageCategorieDisplay?id=${categorie.idCategorie}" width="175px" height="175px"/>

												<h3>${categorie.nomCategorie}</h3>
												<p>${categorie.description}</p>
												<p>
													<a class="btn btn-info"
														href="${pageContext.request.contextPath}/accueil/liste_produit?idCategorie=${categorie.idCategorie}"
														role="button">Voir tous les articles &raquo;</a>
												</p>
												
												<s:authorize access="hasRole('ROLE_CATEGORIE')">
												<p>
													<a class="btn btn-warning"
														href="${pageContext.request.contextPath}/categorie/updateform?idCategorie=${categorie.idCategorie}"
														role="button">Modifier</a>
																											<a class="btn btn-danger"
														href="${pageContext.request.contextPath}/categorie/delete?idCategorie=${categorie.idCategorie}"
														role="button">Supprimer</a>
												</p>
												</s:authorize>
												
											</div>
										</div>
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
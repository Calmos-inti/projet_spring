<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- ======================================= LES TAGLIBS ========================================== -->
<!-- taglib de jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- taglib de Spring Security -->
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<!-- déclaration de la taglib de Spring MVC form -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Titre de la page</title>

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

				<br /> <br />
				<div class="row">
					<!-- =============== inclusion menu gauche ========================== -->

					<div class="col-2">

						<%@ include file="/resources/template/menu_gauche.jsp"%>

					</div>
					<!-- end col-2 -->

					<!-- =============== fin menu gauche ========================== -->


					<!-- =============== début du Core ========================== -->


					<div class="col-10">


						<c:forEach items="${liste_produits}" var="produit">

							<div class="card">
								<div class="card-body ">
									<div class="row">
										<div class="col-3">
											<svg class="bd-placeholder-img rounded-circle" width="140"
												height="140" xmlns="http://www.w3.org/2000/svg"
												preserveAspectRatio="xMidYMid slice" focusable="false"
												role="img" aria-label="Placeholder: 140x140">
					<title>Placeholder</title><rect width="100%" height="100%"
													fill="#777" />
					<text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>
										</div>


										<div class="col-6">
											<h4 class="card-title">${produit.designation}</h4>
											<h6 class="card-subtitle mb-2 text-muted">${produit.categorie.nomCategorie}</h6>
											<p class="card-text">${produit.description}</p>
										</div>



										<div class="col-3">
											<form:form modelAttribute="#" action="#" method="post">

												<h5>${produit.prix} euros</h5>

												<span class="badge badge-success">Encore
													${produit.quantite} articles disponibles ! </span>

												<fieldset>
													<div class="form-group row">
														
														
													
													<label class="col-sm-8 col-form-label" >Quantité :</label>
													 <div class="col-sm-4">
													<select	class="form-control-plaintext" id="#">
														<c:forEach var="i" begin="1" end="${produit.quantite}"
															step="1">
															<option>${i}</option>
														</c:forEach>
													</select>
													</div>
													</div>
												</fieldset>
												<button type="button" class="btn btn-outline-success">Ajouter au Panier</button>
											</form:form>
										</div>


									</div>
								</div>
							</div>
							<br />
						</c:forEach>

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
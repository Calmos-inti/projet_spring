<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- ======================================= LES TAGLIBS ========================================== -->
<!-- taglib de jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- taglib de Spring Security -->
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<!-- d�claration de la taglib de Spring MVC form -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>liste produits</title>

<!-- lib icone : Fontawesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">

<!-- Sp�cification du chemin de la lib Popper -->
<script
	src="<c:url value="/resources/bootstrap-Litera/js/popper.min.js" />"></script>

<!-- Sp�cification du chemin de la lib jQuery -->
<script
	src="<c:url value="/resources/bootstrap-Litera/js/jquery-3.4.1.js" />"></script>

<!-- Sp�cification du chemin la lib js Bootrap � la page -->
<script
	src="<c:url value="/resources/bootstrap-Litera/js/bootstrap.min.js" />"></script>

<!-- Sp�cification du chemin la lib css Bootrap � la page -->
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


					<!-- =============== d�but du Core ========================== -->


					<div class="col-10">

						<c:if test="${nombre_trouve != 0 && mot_cle!=null}">
							<div class="alert alert-dismissible alert-success">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<strong>${nombre_trouve}</strong> article(s) trouv�(s) avec le
								mot-cl� ${mot_cle} !
							</div>
							<br />
						</c:if>

						<c:if test="${nombre_trouve == 0}">
							<div class="alert alert-dismissible alert-warning">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								Aucun article avec le mot-cl� <strong>${mot_cle}</strong> n'a
								�t� trouv� !
							</div>
							<br />
						</c:if>

						<s:authorize access="hasRole('ROLE_PRODUIT')">
						<c:if test="${mot_cle==null}">
							<div class="container">
								<div class="row justify-content-center">
									<div class="col-6 ">
										<button
											onclick="location.href='${pageContext.request.contextPath}/addProduit?idCategorie=${id_categorie}'"
											class="btn btn-outline-secondary btn-lg btn-block "
											type="button">Ajouter un produit</button>
									</div>
								</div>
							</div>
							<br />
						</c:if>
						</s:authorize>

						<c:forEach items="${liste_produits}" var="produit">

							<div class="card">
								<div class="card-body">
									<div class="row">
										<div class="col-3">
											<img src="${pageContext.request.contextPath}/myImage/imageProduitDisplay?id=${produit.idProduit}" width="150px" height="150px"/>
											
										</div>


										<div class="col-6">
											<h4 class="card-title">${produit.designation}</h4>
											<h6 class="card-subtitle mb-2 text-muted">${produit.categorie.nomCategorie}</h6>
											<p class="card-text">${produit.description}</p>
											
											<s:authorize access="hasRole('ROLE_PRODUIT')">
												<p>
													<a class="btn btn-warning"
														href="${pageContext.request.contextPath}/updateProduit?idProduit=${produit.idProduit}"
														role="button">Modifier</a>

													<a class="btn btn-danger"
														href="${pageContext.request.contextPath}/produit/delete?idProduit=${produit.idProduit}"
														role="button">Supprimer</a>
												</p>
												</s:authorize>
										</div>



										<div class="col-3">
											<form:form modelAttribute="produitCommand" action="${pageContext.request.contextPath}/client/ajoutPanier" method="post">
												<form:hidden path="idProduit" value="${produit.idProduit}"/>
												<h5>${produit.prix}&euro;</h5>

												<span class="badge badge-success">Encore
													${produit.quantite} articles disponibles ! </span>
													<s:authorize access="hasRole('ROLE_CLIENT')">
												<fieldset>
													<div class="form-group row">



														<label class="col-sm-8 col-form-label">Quantit� :</label>
														<div class="col-sm-4">
															<form:select class="form-control-plaintext" path="quantite">
																<c:forEach var="i" begin="1" end="${produit.quantite}"
																	step="1">
																	<option>${i}</option>
																</c:forEach>
															</form:select>
														</div>
													</div>
												</fieldset>
												
												<form:button type="submit" class="btn btn-outline-success">Ajouter
													au Panier</form:button>
												</s:authorize>
												<s:authorize access="hasRole('ROLE_ANONYMOUS')">
												<fieldset>
													<div class="form-group row">



														<label class="col-sm-8 col-form-label">Quantit� :</label>
														<div class="col-sm-4">
															
														</div>
													</div>
												</fieldset>
												Vous devez �tre <a href="${pageContext.request.contextPath}/login.jsp">connect�(e)</a> pour commander ce produit
												</s:authorize>
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
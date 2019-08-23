<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- taglib de jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- taglib de Spring Security -->
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
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
				<br />

				<c:forEach items="${liste_commandes}" var="commandes">

					<div class="card">
						<div class="card-body">
							<div class="row">
								<div class="col-8">
									<h6 class="card-title">Numéro de commande :
										${commandes.id}</h6>

									<p class="text-primary">Total : ${commandes.total} &euro;</p>
								</div>
								<div class="col-4">
									<p>
										<c:if test="${commandes.valider eq true}">
											<span class="badge badge-success">Validée</span>
										</c:if>

										<c:if test="${commandes.valider eq false}">
											<span class="badge badge-warning mr-sm-2">En cours de
												validation</span>
										</c:if>
									</p>
									<p>
										<a class="btn btn-info" href="" data-toggle="collapse"
											data-target="#detail${commandes.id}" role="button">Détail
											&raquo;</a>
									</p>
								</div>
							</div>
							<div id="detail${commandes.id}" class="collapse">
								<div class="container">

									<ul class="list-group">
										<c:forEach items="${commandes.listeLignePanier}" var="ligne">
											<li class="list-group-item d-flex justify-content-between align-items-center">
												<span>x ${ligne.quantité}</span> 
												<span class="text-primary">${ligne.produit.categorie.nomCategorie}</span>
												<span>${ligne.produit.designation}</span>
												<span>Prix unitaire : ${ligne.produit.prix} &euro;</span>
												
												<span>total : <span class="badge badge-primary">${ligne.prix} &euro;</span></span>
											</li>
										</c:forEach>
										
										

									</ul>


								</div>
							</div>
						</div>
					</div>

					<br />
				</c:forEach>

			</div>
		</div>
	</div>

	<br />
	<br />
	<!-- =============== inlusion du footer ========================== -->
	<%@ include file="/resources/template/footer.jsp"%>

</body>
</html>
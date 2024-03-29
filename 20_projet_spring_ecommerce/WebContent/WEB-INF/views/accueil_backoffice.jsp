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
				<br />
				<%@ include file="/resources/template/barre_recheche.jsp"%>
				<br />
				<!-- =============== end Barre recherche ========================== -->


				<div align="center">
					<h1>Administration Manager</h1>
				</div>
				<br /> <br />
				
				<c:forEach items="${liste_commandes}" var="commandes">
					<c:if test="${commandes.valider eq false}">
					<div class="card">
						<div class="card-body">
							<div class="row">
								<div class="col-8">
									<h6 class="card-title">Num�ro de commande :
										${commandes.id}</h6>

									<p class="text-primary">Total : ${commandes.total} &euro;</p>
								</div>
								<div class="col-4">
									<p>

										<button type="button" class="btn btn-outline-success"
						onclick="location.href='${pageContext.request.contextPath}/produit/validerCommande?id=${commandes.id}'">Valider</button>
								
										
									
									</p>
									<p>
										<a class="btn btn-info" href="" data-toggle="collapse"
											data-target="#detail${commandes.id}" role="button">D�tail
											&raquo;</a>
									</p>
								</div>
							</div>
							<div id="detail${commandes.id}" class="collapse">
								<div class="container">

									<ul class="list-group">
										<c:forEach items="${commandes.listeLignePanier}" var="ligne">
											<li class="list-group-item d-flex justify-content-between align-items-center">
												<span>x ${ligne.quantite}</span> 
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
					</c:if>
				</c:forEach>
				
				


			
		</div>
	</div>


	<br />
	<br />
	<!-- =============== inlusion du footer ========================== -->
	<%@ include file="/resources/template/footer.jsp"%>

</body>
</html>
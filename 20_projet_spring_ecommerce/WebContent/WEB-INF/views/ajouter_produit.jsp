<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- taglib de jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- taglib de Spring Security -->
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html >
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

				<form action="${pageContext.request.contextPath}/produit/add"
					method="post" enctype="multipart/form-data">

					<div class="row">
						<div class="col-6">

							<br />
							<div class="form-group row justify-content-md-center">

								<label class="col-sm-2 col-form-label">Nom</label>

								<div class="col-sm-7">
									<input type="text" name="designation" class="form-control"
										placeholder="Nom du produit" />
								</div>

							</div>

							<div class="form-group row justify-content-md-center">

								<label class="col-sm-2 col-form-label">Catégorie</label>

								<div class="col-sm-7">
									<input type="text" class="form-control"
										value="${categorie.nomCategorie}" readonly="readonly" /> <input
										type="hidden" type="number" name="idCategorie"
										value="${categorie.idCategorie}" />

								</div>

							</div>

							<div class="form-group row justify-content-md-center">

								<label class="col-sm-2 col-form-label">Description</label>

								<div class="col-sm-7">
									<textarea class="form-control"
										placeholder="Description du produit" name="description"
										rows="3"></textarea>
								</div>

							</div>
						</div>
						<!-- end col-6 -->
						<div class="col-6">


							<br />
							<div class="form-group row justify-content-md-center">

								<label class="col-sm-3 col-form-label">Prix</label>

								<div class="col-sm-7">
									<input type="number" name="prix" class="form-control"
										placeholder="Prix du produit" />
								</div>

							</div>

							<div class="form-group row justify-content-md-center">

								<label class="col-sm-3 col-form-label">Quantité</label>

								<div class="col-sm-7">
									<input type="number" name="quantite" class="form-control"
										placeholder="Quantité initiale" />
								</div>

							</div>

							<div class="form-group row justify-content-md-center">

								<label class="col-sm-3 col-form-label">Photo</label>

								<div class="col-sm-7">
									<input name="photo" type="file" />
								</div>

							</div>



						</div>
						<!-- end col-6 -->
					</div>
					<!-- end row -->
					<br /> <br />
					<div class="row justify-content-center">
						<div class="col-4">
							<div class="form-group row justify-content-md-center">
								<button class="btn btn-outline-primary btn-lg btn-block"
									type="submit">Ajouter ce produit</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<br />
	<br />
	<!-- =============== inlusion du footer ========================== -->
	<%@ include file="/resources/template/footer.jsp"%>

</body>
</html>
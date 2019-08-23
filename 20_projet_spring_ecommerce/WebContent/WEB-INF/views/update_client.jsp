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
<title>Nouveau Compte</title>

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

				<br /> <br />

				<form:form modelAttribute="clientCommandUpadate" action="${pageContext.request.contextPath}/client/updateClient" method="post">
					
					<form:hidden path="id"/>
					<form:hidden path="enabled"/>
					<div class="row">
						<div class="col-6">
							<fieldset>
								<legend align="center">Informations personnelles</legend>
							</fieldset>
							<br />
							<div class="form-group row justify-content-md-center">

								<form:label class="col-sm-2 col-form-label" path="nom">Nom</form:label>

								<div class="col-sm-7">
									<form:input type="text" class="form-control"
										placeholder="Entrez votre nom" path="nom" />
								</div>

							</div>

							<div class="form-group row justify-content-md-center">

								<form:label class="col-sm-2 col-form-label" path="adresse">Adresse</form:label>

								<div class="col-sm-7">
									<form:input type="text" class="form-control"
										placeholder="Entrez votre adresse" path="adresse" />
								</div>

							</div>

							<div class="form-group row justify-content-md-center">

								<form:label class="col-sm-2 col-form-label" path="telephone">Téléphone</form:label>

								<div class="col-sm-7">
									<form:input type="text" class="form-control"
										placeholder="Entrez votre numéro de téléphone"
										path="telephone" />
								</div>

							</div>
						</div>
						<!-- end col-6 -->
						<div class="col-6">

							<fieldset>
								<legend align="center">Informations sur le compte</legend>
							</fieldset>
							<br />
							<div class="form-group row justify-content-md-center">

								<form:label class="col-sm-3 col-form-label" path="mail" >Mail</form:label>

								<div class="col-sm-7">
									<form:input type="text" class="form-control"
										placeholder="Entrez votre adresse mail" path="mail" readonly="true"/>
								</div>

							</div>

							<div class="form-group row justify-content-md-center">

								<form:label class="col-sm-3 col-form-label" path="password">Mot de passe</form:label>

								<div class="col-sm-7">
									<form:input type="password" class="form-control"
										placeholder="Entrez votre mot de passe" path="password" />
								</div>

							</div>


						</div>
						<!-- end col-6 -->
					</div>
					<!-- end row -->
					<br />
					<br />
					<div class="row justify-content-center">
						<div class="col-4">
							<div class="form-group row justify-content-md-center">
								<form:button class="btn btn-outline-primary btn-lg btn-block" type="submit">Modifier le compte</form:button>
							</div>
						</div>
					</div>
				</form:form>

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
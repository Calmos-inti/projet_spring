<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

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
<body class="text-center">

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-3 align-self-center ">
				<br />
				<br />
				<br />


				<!-- Construction de l'url d'authentification à la soumission du formulaire -->
				<c:url value="login" var="loginUrl" />

				<form class="form-signin" action="${loginUrl}" method="post">

					<h1 class="h2 mb-3 font-weight-normal">Connectez-vous</h1>

					<c:if test="${not empty param.error}">
						<br />
						<div class="alert alert-dismissible alert-danger">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>Connexion impossible!</strong> Veuillez vous connecter avec une adresse mail et un mot de passe valide.
						</div>
						
					</c:if>
					<br /> <label for="inputEmail" class="sr-only">Email
						address</label> <input type="email" name="username" class="form-control"
						placeholder="Adresse mail" required> <label
						for="inputPassword" class="sr-only">Password</label> <input
						type="password" id="inputPassword" class="form-control"
						name="password" placeholder="Mot de passe" required>

					<div class="checkbox mb-3">
						<br />

					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Connexion</button>
					<br /> <br />
				</form>
					
					
									<!-- ////////////////////Affichage du message de deconnexion///////////
	récup du param : /login.jsp?logout_message=true -->

				<c:if test="${not empty param.logout_message}">
					<div class="alert alert-dismissible alert-success">
					  <button type="button" class="close" data-dismiss="alert">&times;</button>
					  Vous vous êtes correctement déconnecté(e).
					</div>
					<br/>
					<a href="${pageContext.request.contextPath}/accueil">retour à la page d'accueil</a>
					<br/><br/>
				</c:if>
					
					
				<h4>
					<small class="text-muted">NOUVEAU CLIENT ?</small>
				</h4>
				<br />
				<button type="button" class="btn btn-outline-primary btn-lg"
					onclick="location.href='${pageContext.request.contextPath}/accueil/creerCompte'">Créer un Compte</button>

				<br />
				<p class="mt-5 mb-3 text-muted">&copy; 2019 AKC Shop, Inc.</p>

			</div>
		</div>
	</div>
</body>
</html>
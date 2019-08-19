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
<title>Acceuil</title>

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
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">AKC Shop</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarCollapse" aria-controls="navbarCollapse"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarCollapse">

				<ul class="navbar-nav mr-auto">
					<!-- coté gauche -->

					<!-- à faire : rendre la balise accessible uniquement au 'ROLE_PRODUIT' -->
					<li class="nav-item"><a class="nav-link" href="#">Manager
							Produit</a></li>

					<!-- à faire : rendre la balise accessible uniquement au 'ROLE_CATEGORIE' -->
					<li class="nav-item"><a class="nav-link" href="#">Manager
							Catégorie</a></li>
				</ul>
				<!-- end coté gauche -->

				<!-- coté droit -->
				<button type="button"
					class="btn btn-outline-primary justify-content-end">Panier
				</button>

				<ul class="navbar-nav justify-content-end">

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="dropdown07"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Mon
							Espace</a>
						<div class="dropdown-menu" aria-labelledby="dropdown07">
							<a class="dropdown-item" href="#">Mes Commandes</a> <a
								class="dropdown-item" href="#">Modifier Profil</a> <a
								class="dropdown-item" href="#">Déconnexion</a>
						</div></li>
					<!-- end dropdown 'mon espace' -->

					<!-- à faire : rendre la balise accessible uniquement au 'ROLE_ANONYMOUS' -->
					<li class="nav-item"><a class="nav-link" href="#">Connexion</a></li>

				</ul>
				<!-- end coté droit -->
			</div>
		</nav>
	</header>





	<main role="main"> <br />
	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="col-sm-10 ">


				<!-- =============== Carousel ========================== -->

				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>

					<div class="carousel-inner">

						<div class="carousel-item active">
							<svg class="bd-placeholder-img" width="100%" height="100%"
								xmlns="http://www.w3.org/2000/svg"
								preserveAspectRatio="xMidYMid slice" focusable="false"
								role="img">
					<rect width="100%" height="100%" fill="#777" /></svg>

							<div class="container">
								<div class="carousel-caption text-left">
									<h1>Image 1</h1>
								</div>
							</div>
						</div>


						<div class="carousel-item">
							<svg class="bd-placeholder-img" width="100%" height="100%"
								xmlns="http://www.w3.org/2000/svg"
								preserveAspectRatio="xMidYMid slice" focusable="false"
								role="img">
					<rect width="100%" height="100%" fill="#777" /></svg>
							<div class="container">
								<div class="carousel-caption text-left">
									<h1>Image 2</h1>
								</div>
							</div>
						</div>

						<div class="carousel-item">
							<svg class="bd-placeholder-img" width="100%" height="100%"
								xmlns="http://www.w3.org/2000/svg"
								preserveAspectRatio="xMidYMid slice" focusable="false"
								role="img">
					<rect width="100%" height="100%" fill="#777" /></svg>
							<div class="container">
								<div class="carousel-caption text-left">
									<h1>Image 3</h1>
								</div>
							</div>
						</div>
					</div>

					<a class="carousel-control-prev" href="#myCarousel" role="button"
						data-slide="prev"> <span class="carousel-control-prev-icon"
						aria-hidden="true"></span> <span class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#myCarousel" role="button"
						data-slide="next"> <span class="carousel-control-next-icon"
						aria-hidden="true"></span> <span class="sr-only">Next</span>
					</a>

				</div>
				<!-- =============== end carousel ========================== -->
				<br /> <br />
				<div class="row">
				<!-- =============== menu gauche ========================== -->
				
					<div class="col-2">

						<ul class="nav flex-column">
						
							<c:forEach items="${liste_categories}" var="categorie">
								<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="dropdown07"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${categorie.nomCategorie}</a>
							<div class="dropdown-menu" aria-labelledby="dropdown07">
								<c:forEach items="${categorie.listeProduits}" var="produit">
									<a class="dropdown-item" href="#">${produit.designation}</a> 
								</c:forEach>
							</div></li>
							</c:forEach>
						
						</ul> <!-- end nav flex-column -->

					</div> 	<!-- end col-2 -->

	
				<!-- =============== fin menu gauche ========================== -->



				<!-- =============== début du Core ========================== -->

				<div class="col-8 ">
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
									<a class="btn btn-secondary" href="#" role="button">voir la
										liste &raquo;</a>
								</p>
							</div>
						</c:forEach>
	



						</div>	<!-- end row -->
					</div> <!-- end conteneur marketing --> 
				</div> <!-- end col-8 -->
				<!-- =============== fin du Core ========================== -->

			</div> <!-- end row -->
		</div> <!-- end col-sm-10 -->
	</div>	<!-- end row justify-content-center -->
</div>	<!-- end container-fluid -->


	<!-- /.container --> <!-- FOOTER --> <footer class="container">
		<br /> <br />
		<p class="float-right">
			<a href="#">Back to top</a>
		</p>
		<p>&copy; 2019 AKC Shop, Inc.</p>
	</footer> </main>
</body>
</html>
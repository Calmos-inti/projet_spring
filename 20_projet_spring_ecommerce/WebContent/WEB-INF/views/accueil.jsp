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
				<br /><br/>

				<!-- =============== menu gauche ========================== -->
				<div class="row">
					<div class="col-2">

						<div class="accordion" id="accordionExample">


							<div class="card">
								<div class="card-header" id="heading1">
									<h6 class="mb-0">
										<button class="btn btn-link" type="button"
											data-toggle="collapse" data-target="#collapseOne"
											aria-expanded="true" aria-controls="collapseOne">
											Categorie 1</button>
									</h6>
								</div>

								<div id="collapseOne" class="collapse show"
									aria-labelledby="headingOne" data-parent="#accordionExample">
									<div class="card-body">
									
									<a href="#">Categorie 1-Produit 1</a>
									<a href="#">Categorie 1-Produit 2</a>
									<a href="#">Categorie 1-Produit 3</a>
									
									</div>
	
								</div>
							</div>


							<div class="card">
								<div class="card-header" id="headingTwo">
									<h6 class="mb-0">
										<button class="btn btn-link collapsed" type="button"
											data-toggle="collapse" data-target="#collapseTwo"
											aria-expanded="false" aria-controls="collapseTwo">
											Categorie 2</button>
									</h6>
								</div>
								<div id="collapseTwo" class="collapse"
									aria-labelledby="headingTwo" data-parent="#accordionExample">
									<div class="card-body">									
									<a href="#">Categorie 2-Produit 1</a>
									<a href="#">Categorie 2-Produit 2</a>
									<a href="#">Categorie 2-Produit 3</a>
									</div>
								</div>
							</div>


							<div class="card">
								<div class="card-header" id="headingThree">
									<h6 class="mb-0">
										<button class="btn btn-link collapsed" type="button"
											data-toggle="collapse" data-target="#collapseThree"
											aria-expanded="false" aria-controls="collapseThree">
											Categorie 3</button>
									</h6>
								</div>
								<div id="collapseThree" class="collapse"
									aria-labelledby="headingThree" data-parent="#accordionExample">
									
									<div class="card-body">
										<a href="#">Categorie 3-Produit 1</a>
										<a href="#">Categorie 3-Produit 2</a>
										<a href="#">Categorie 3-Produit 3</a>
									</div>
								</div>
							</div>
						</div>


					</div>
					<!-- =============== fin menu gauche ========================== -->



					<!-- =============== début du Core ========================== -->

					<div class="col-8 ">
						<div class="container marketing">

							<div class="row">
								<div class="col-4">
									<svg class="bd-placeholder-img rounded-circle" width="140"
										height="140" xmlns="http://www.w3.org/2000/svg"
										preserveAspectRatio="xMidYMid slice" focusable="false"
										role="img" aria-label="Placeholder: 140x140">
					<title>Placeholder</title><rect width="100%" height="100%"
											fill="#777" />
					<text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>
									<h3>Catégorie1</h3>
									<p>description</p>
									<p>
										<a class="btn btn-secondary" href="#" role="button">voir
											la liste &raquo;</a>
									</p>
								</div>

								<div class="col-4">
									<svg class="bd-placeholder-img rounded-circle" width="140"
										height="140" xmlns="http://www.w3.org/2000/svg"
										preserveAspectRatio="xMidYMid slice" focusable="false"
										role="img" aria-label="Placeholder: 140x140">
					<title>Placeholder</title><rect width="100%" height="100%"
											fill="#777" />
					<text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>
									<h3>Catégorie2</h3>
									<p>description</p>
									<p>
										<a class="btn btn-secondary" href="#" role="button">voir
											la liste &raquo;</a>
									</p>
								</div>


								<div class="col-4">
									<svg class="bd-placeholder-img rounded-circle" width="140"
										height="140" xmlns="http://www.w3.org/2000/svg"
										preserveAspectRatio="xMidYMid slice" focusable="false"
										role="img" aria-label="Placeholder: 140x140">
					<title>Placeholder</title><rect width="100%" height="100%"
											fill="#777" />
					<text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>
									<h3>Catégorie3</h3>
									<p>description</p>
									<p>
										<a class="btn btn-secondary" href="#" role="button">voir
											la liste &raquo;</a>
									</p>
								</div>



							</div>
							<!-- end row -->
						</div>
					</div>
					<!-- =============== fin du Core ========================== -->

				</div>
			</div>
		</div>
	</div>
	<!-- /.container --> <!-- FOOTER --> <footer class="container">
	<br/><br/>
		<p class="float-right">
			<a href="#">Back to top</a>
		</p>
		<p>&copy; 2019 AKC Shop, Inc.</p>
	</footer> </main>
</body>
</html>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">


	<div class="collapse navbar-collapse" id="navbarColor01">
		<ul class="navbar-nav mr-auto">

			<!-- Tâches gestionnaire produit -->
			<li class="nav-item active"><a class="nav-link" href="#">Gestion
					Commandes <span class="sr-only">(current)</span>
			</a></li>

			<li class="nav-item"><a class="nav-link" href="#">Nouveau
					Produit</a></li>

			<!-- Tâches gestionnaire catégorie -->
			<li class="nav-item"><a class="nav-link" href="#">Nouvelle
					Catégorie</a></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="dropdown07"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gestion
					Employés</a>
				<div class="dropdown-menu" aria-labelledby="dropdown07">
					<a class="dropdown-item" href="#">Afficher Tous</a> <a
						class="dropdown-item" href="#">Ajouter</a>
				</div></li>
		</ul>

		<form class="form-inline my-2 my-lg-0" method="get"
			action="${pageContext.request.contextPath}/accueil/recherche">
			<input class="form-control mr-sm-2" type="text"
				placeholder="Recherche par mot-clé" name="mot">
			<button class="btn btn-success my-2 my-sm-0" type="submit">
				<i class="fas fa-search"></i> Chercher
			</button>
		</form>

	</div>
</nav>
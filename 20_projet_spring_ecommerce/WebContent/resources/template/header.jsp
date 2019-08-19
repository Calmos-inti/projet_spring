<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/accueil">AKC Shop</a>
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
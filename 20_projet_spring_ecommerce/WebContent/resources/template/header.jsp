<header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand"
			href="${pageContext.request.contextPath}/accueil">AKC Shop</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarCollapse">

			<ul class="navbar-nav mr-auto">
				<!-- cot� gauche -->

				<!-- � faire : rendre la balise accessible uniquement au 'ROLE_PRODUIT' -->
				<li class="nav-item"><a class="nav-link" href="#">Manager
						Produit</a></li>

				<!-- � faire : rendre la balise accessible uniquement au 'ROLE_CATEGORIE' -->
				<li class="nav-item"><a class="nav-link" href="#">Manager
						Cat�gorie</a></li>
			</ul>
			<!-- end cot� gauche -->

			<!-- cot� droit -->
			<form class="form-inline" method="get" action="${pageContext.request.contextPath}/accueil/recherche">
      <input class="form-control form-control-sm mr-sm-2" type="text" placeholder="Rechercher" name="mot">
      <button class="btn btn-primary btn-sm my-2 my-sm-0" type="submit"><i class="fas fa-search"></i></button>
    </form>

			<ul class="navbar-nav justify-content-end">

				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					data-target="#panier" href="#"><i class="fas fa-shopping-cart"></i> Panier</a></li>


				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdown07"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user"></i> Mon
						Espace</a>
					<div class="dropdown-menu" aria-labelledby="dropdown07">
						<a class="dropdown-item" href="#">Mes Commandes</a> <a
							class="dropdown-item" href="#">Modifier Profil</a>
					</div></li>
				<!-- end dropdown 'mon espace' -->

				<s:authorize access="hasRole('ROLE_ANONYMOUS')">

					<button type="button" class="btn btn-outline-success"
						onclick="location.href='${pageContext.request.contextPath}/login.jsp'">Se
						Connecter</button>

				</s:authorize>

				<s:authorize access="hasAnyRole('ROLE_CLIENT', 'ROLE_PRODUIT')">

					<button type="button" class="btn btn-outline-danger"
						onclick="location.href='${pageContext.request.contextPath}/logout'">Se
						D�connecter</button>

				</s:authorize>
			</ul>
			<!-- end cot� droit -->
		</div>
	</nav>


	<div id="panier" class="collapse">
		<div class="container">
			<br/>
			<div class="row">
				<div class="col-8"></div>
				<div class="col-4 align-self-end">

					<ul class="list-group">
						<li
							class="list-group-item d-flex justify-content-between align-items-center">
							<a href="#"><i class="far fa-trash-alt"></i></a> x 2  -  Produit 1 <span class="badge badge-primary">20 &euro;</span>
						</li>
						
						<li
							class="list-group-item d-flex justify-content-between align-items-center">
							<a href="#"><i class="far fa-trash-alt"></i></a>x 5  -  Produit 2 <span class="badge badge-primary">75 &euro;</span>
						</li>
						
						
						<li
							class="list-group-item d-flex justify-content-between align-items-center">
							<a href="#"><i class="far fa-trash-alt"></i></a>x 8  -  Produit 3 <span class="badge badge-primary">30 &euro;</span>
						</li>
						
						<li
							class="list-group-item d-flex justify-content-between align-items-center">
							Total : <span class="badge badge-primary">115 &euro;</span>
						</li>
						
						<li
							class="list-group-item d-flex justify-content-between align-items-center">
							Finaliser ma commande <button type="button" class="btn btn-success">Valider</button>
						</li>
						
					</ul>
					

				</div>

			</div>
		</div>
	</div>



</header>
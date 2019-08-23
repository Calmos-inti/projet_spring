
<!-- taglib de jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
				<!-- coté gauche -->

				<!-- à faire : rendre la balise accessible uniquement au 'ROLE_PRODUIT' -->
				
				<s:authorize access="hasRole('ROLE_PRODUIT')">
					<li class="nav-item"><span class="badge badge-warning mr-sm-2">Manager Produit</span></li>
				</s:authorize>
			
				<s:authorize access="hasRole('ROLE_CATEGORIE')">
				<li class="nav-item"><span class="badge badge-danger mr-sm-2">Manager Catégorie</span></li>
				</s:authorize>
				
				<s:authorize access="hasRole('ROLE_PRODUIT')">
				<li class="nav-item"><a href="${pageContext.request.contextPath}/accueil_backoffice">Partie Administration</a></li>
				</s:authorize>
				
			
			</ul>
			<!-- end coté gauche -->

			<!-- coté droit -->
			<ul class="navbar-nav justify-content-end">

				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					data-target="#panier" href="#"><i class="fas fa-shopping-cart"></i>
						Panier</a></li>


				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdown07"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i
						class="fas fa-user"></i> Mon Espace</a>
					<div class="dropdown-menu" aria-labelledby="dropdown07">
						<a class="dropdown-item" href="${pageContext.request.contextPath}/client/afficherCommandes">Mes Commandes</a> <a
							class="dropdown-item" href="${pageContext.request.contextPath}/client/formulaireUpdate">Modifier Profil</a>
					</div></li>
				<!-- end dropdown 'mon espace' -->

				<s:authorize access="hasRole('ROLE_ANONYMOUS')">
					
					<button type="button" class="btn btn-outline-primary mr-sm-2"
						onclick="location.href='${pageContext.request.contextPath}/accueil/creerCompte'">S'inscrire</button>
					
				
					<button type="button" class="btn btn-outline-success"
						onclick="location.href='${pageContext.request.contextPath}/login.jsp'">Se
						Connecter</button>

				</s:authorize>

				<s:authorize access="hasAnyRole('ROLE_CLIENT', 'ROLE_PRODUIT')">

					<li class="nav-item" ><a class="nav-link text-danger" 
						href="${pageContext.request.contextPath}/logout"><i
							class="fas fa-power-off"></i> Se Déconnecter</a></li>

				</s:authorize>
			</ul>
			<!-- end coté droit -->
		</div>
	</nav>

<!-- ///////////////////////panier ////////////////////////////////// -->

	<div id="panier" class="collapse">
		<div class="container">
			<br />
			<div class="row">
				<div class="col-8"></div>
				<div class="col-4 align-self-end">

					<ul class="list-group">
					<c:forEach items="${liste_lignePaniers}" var = "var">
						<li
							class="list-group-item d-flex justify-content-between align-items-center">
							<a href="${pageContext.request.contextPath}/ligne_panier/delete/{pLignePanierId}"><i class="far fa-trash-alt"></i></a> x ${var.quantité} - ${var.produit.designation}
							<span class="badge badge-primary">20 &euro;</span>
						</li>
					</c:forEach>
					
					
					
						<li
							class="list-group-item d-flex justify-content-between align-items-center">
							Total : <span class="badge badge-primary">115 &euro;</span>
						</li>

						<li
							class="list-group-item d-flex justify-content-between align-items-center">
							Finaliser ma commande
							<button type="button" class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/client/validerPanier'">Valider</button>
						</li>

					</ul>


				</div>

			</div>
		</div>
	</div>



</header>
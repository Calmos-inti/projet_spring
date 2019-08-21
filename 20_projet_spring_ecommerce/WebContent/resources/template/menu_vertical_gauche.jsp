

<ul class="nav flex-column">
  <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/addProduit">Ajouter un produit</a>
  </li>
  <s:authorize access="hasRole('ROLE_CATEGORIE')">
    <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/addCategorie">Ajouter une catégorie</a>
  </li>  </s:authorize>
    <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/produit/liste/">Afficher la liste des produits</a>
  </li>

    <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/categorie/liste/">Afficher la liste de catégories</a>
  </li>

   <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/accueil_backoffice">Retour accueil</a>
  </li>


</ul>
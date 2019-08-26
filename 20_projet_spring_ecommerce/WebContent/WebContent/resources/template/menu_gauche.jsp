


<c:forEach items="${liste_categories}" var="categorie">
	<div class="row">
		<div class="btn-group col-12" role="group"
			aria-label="Button group with nested dropdown">
			<button type="button" class="btn btn-outline-primary"
				onclick="location.href='${pageContext.request.contextPath}/accueil/liste_produit?idCategorie=${categorie.idCategorie}'">
				${categorie.nomCategorie}</button>
			<div class="btn-group" role="group">
				<button id="btnGroupDrop1" type="button"
					class="btn btn-outline-primary dropdown-toggle"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></button>
				<div class="dropdown-menu" aria-labelledby="btnGroupDrop1"
					x-placement="bottom-start"
					style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(0px, 39px, 0px);">
					<c:forEach items="${categorie.listeProduits}" var="produit">
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/accueil/produit?idProduit=${produit.idProduit}">${produit.designation}</a>
					</c:forEach>
				</div>
			</div>

		</div>
	</div>
	<div>
		<br />
	</div>
</c:forEach>
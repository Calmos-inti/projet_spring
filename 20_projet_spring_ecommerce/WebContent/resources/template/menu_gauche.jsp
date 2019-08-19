<ul class="nav flex-column">
						
	<c:forEach items="${liste_categories}" var="categorie">
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="dropdown07"
			data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${categorie.nomCategorie}</a>
							
			<div class="dropdown-menu" aria-labelledby="dropdown07">
				
				<c:forEach items="${categorie.listeProduits}" var="produit">
					<a class="dropdown-item" href="#">${produit.designation}</a> 
				</c:forEach>
			</div>
		</li>
	</c:forEach>
						
</ul> <!-- end nav flex-column -->
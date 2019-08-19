package fr.adaming.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller
public class AccueilController {

	@Autowired
	private ICategorieService categorieManager;

	// setter pour injection spring
	public void setCategorieManager(ICategorieService categorieManager) {
		this.categorieManager = categorieManager;
	}
	
	@Autowired
	private IProduitService produitManager;

	// setter pour injection spring
	public void setProduitManager(IProduitService produitManager) {
		this.produitManager = produitManager;
	}
	

	public void infoMenu_gauche(ModelMap modelDonnees) {

		// Recupération de la liste des categories depuis la BDD
		List<Categorie> listeCategories = categorieManager.getAllCategories();

		// Encapsulation de la liste dans l'objet ModelMap
		modelDonnees.addAttribute("liste_categories", listeCategories);

	}

	@RequestMapping(value = "/accueil")
	public String allerAccueil(ModelMap modelDonnees) {

		/* ________ Récupération des infos pour la page accueil ___________________ */

		infoMenu_gauche(modelDonnees);

		return "accueil";
	}

	@RequestMapping(value = "/accueil/liste_produit")
	public String listerProduits(@RequestParam("idCategorie") int pIdCategorie, ModelMap modelDonnees) {
		
		infoMenu_gauche(modelDonnees);

		// Recupération de la liste des produits depuis la BDD
		List<Produit> listeProduit = categorieManager.getCategorie(pIdCategorie).getListeProduits();

		// Etape 2 : Encapsulation de la liste dans l'objet ModelMap
		modelDonnees.addAttribute("liste_produits", listeProduit);

		return "accueil_listeProduits";
	}
	
	@RequestMapping(value = "/accueil/produit")
	public String rechercheProduitsbyId(@RequestParam("idProduit") int pIdProduit, ModelMap modelDonnees) {
		
		infoMenu_gauche(modelDonnees);

		// Recupération de la liste des produits depuis la BDD
		Produit produit = produitManager.getProduit(pIdProduit);
		
		List<Produit> listeProduit = new ArrayList<>();
		listeProduit.add(produit);
		
		// Etape 2 : Encapsulation de la liste dans l'objet ModelMap
		modelDonnees.addAttribute("liste_produits", listeProduit);

		return "accueil_listeProduits";
	}

}

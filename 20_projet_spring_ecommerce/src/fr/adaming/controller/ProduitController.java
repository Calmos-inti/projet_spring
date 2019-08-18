package fr.adaming.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;



@Controller
public class ProduitController {
	@Autowired
	private IProduitService produitManager;

	// setter pour injection spring
	public void setProduitManager(IProduitService produitManager) {
		this.produitManager = produitManager;
	}

	/* ___________________méthodes gestionnaires_________________________*/
	
	@RequestMapping(value = "/produit/liste", method = RequestMethod.GET)
	public String listeProduitsBDD(ModelMap modelDonnees) {

		//Etape 1 : recupération de la liste des categories depuis la BDD
		List<Produit> listeProduits = produitManager.getAllProduit();

		//Etape 2 : Encapsulation de la liste dans l'objet ModelMap
		modelDonnees.addAttribute("liste_produits", listeProduits);

		//Etape 3 : Définition du nom logique de la vue
		String nomVue = "liste_des_produits";

		return nomVue;

	} 



	@RequestMapping(value = { "/produit/delete/{pProduitId}"}, method = RequestMethod.GET)
	public String deleteCategorieBdd(@PathVariable("pProduitId") int aProduitId,
			ModelMap modelDonnees) {

		//Etape 1 : suppression de la catégorie depuis la BDD
		produitManager.deleteProduit(aProduitId);
		
		//Etape 2 : recup de la nouvelle liste de catégories et défintion du modèle de données
		List<Produit> listeProduitsBDD = produitManager.getAllProduit();
		modelDonnees.addAttribute("liste_produits", listeProduitsBDD);

		// Etape 3 : Renvoi non logique + redirection
		return "redirect:/produit/liste";

	} 


	@RequestMapping(value = "/addProduit", method = RequestMethod.GET)
	private ModelAndView setUpFormulaireAjout() {
		
		//Etape 1 : création de l'objet à retourner pour les données
		Map<String, Object> data = new HashMap<String, Object>();
		Produit produit = new Produit();
		
		data.put("produitCommand", produit);
		
		// Etape 2 : cration nom logique vue + renvoi du ModelandView
		String nomVue = "ajouter_produit";
		
		return new ModelAndView(nomVue, data);

	}
	
	@RequestMapping(value="/produit/add", method=RequestMethod.POST)
	public String addCategorieBdd(@ModelAttribute("produitCommand") Produit pProduit, ModelMap modeleDonnees) {
		
		produitManager.addProduit(pProduit);
		
		//redirection vers liste_fonctionnaires
		modeleDonnees.addAttribute("liste_produits", produitManager.getAllProduit());
		
		return "redirect:/produit/liste";
		
	} 
	
	
	@RequestMapping(value="/produit/updateform", method=RequestMethod.GET)
	public ModelAndView setUpFormulaireUpdate(@RequestParam("fonctId") int pIdFonc) {
		
		//Etape 1 : récupération de la catégorie à modifier (via son ID) 
		Produit produitUpdate = produitManager.getProduit(pIdFonc);
		
		//Etape 2 : redirection vers la page de modif + Envoi du fonctionnaire  pour modifier la catégorie
		return new ModelAndView("update_produit", "produitUpCommand", produitUpdate);	
	} 
	

	@RequestMapping(value="/produit/update", method=RequestMethod.POST)
	public String updateFonctionnaireBDD(@ModelAttribute("produitUpCommand") Produit produitUpdate, ModelMap modeleDonnes) {
		
		produitManager.updateProduit(produitUpdate);
		
		// 2. recup de la liste des fonctionnaire dans la bdd
		modeleDonnes.addAttribute("liste_produits", produitManager.getAllProduit());
		
		return "redirect:/produit/liste";
		
	}
}

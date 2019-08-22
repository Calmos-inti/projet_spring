package fr.adaming.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.IPanierService;

@Controller
public class PanierController {
	
	
	/* _______________ Déclaration de la classe Service ________________ */
	
	@Autowired
	private IPanierService panierManager;
	
	//setter pour injection spring

	public void setPanierManager(IPanierService panierManager) {
		this.panierManager = panierManager;
	}
	
	/* _____________________ TESTS PANIER________________________________ */
	
	@RequestMapping(value="/panier/test")
	public String tester() {
		
		return "testProduit";
	}
	
	@RequestMapping(value = "/panier/liste", method = RequestMethod.GET)
	public String listePaniersBDD(ModelMap modelDonnees) {
		
		//Etape 1 : recupération de la liste des paniers depuis la BDD
		List<Panier> listePaniers = panierManager.getAllPanierService();
		
		//Etape 2 : Encapsulation de la liste dans l'objet ModelMap
		modelDonnees.addAttribute("liste_paniers", listePaniers);
		
		//Etape 3 : Définition du nom logique de la vue
		String nomVue = "liste_des_paniers";

		return nomVue;
		
		
	}
	
	
	@RequestMapping(value = { "/panier/delete/{pPanierId}"}, method = RequestMethod.GET)
	public String deletePanierBDD(@PathVariable("pPanierId") int aPanierId,
			ModelMap modelDonnees) {
		
		//Etape 1 : suppression de la catégorie depuis la BDD
		panierManager.deletePanierService(aPanierId);
		
		//Etape 2 : recup de la nouvelle liste de catégories et défintion du modèle de données
		List<Panier> listePanierBDD = panierManager.getAllPanierService();
		modelDonnees.addAttribute("liste_paniers", listePanierBDD);

		// Etape 3 : Renvoi non logique + redirection
		return "";
	}
	
	
	@RequestMapping(value = "/addPanier", method = RequestMethod.GET)
	private ModelAndView setUpFormulaireAjout() {
		
		//Etape 1 : création de l'objet à retourner pour les données
		Map<String, Object> data = new HashMap<String, Object>();
		Panier panier = new Panier();
		
		data.put("panierCommand", panier);
		
		// Etape 2 : création du nom logique vue + renvoi du ModelandView
		String nomVue = "ajouter_panier";
		
		return new ModelAndView(nomVue, data);

	}
	
	@RequestMapping(value="/panier/add", method=RequestMethod.POST)
	public String addPanierBDD(@ModelAttribute("panierCommand") Panier pPanier, ModelMap modeleDonnees) {
		
		panierManager.addPanierService(pPanier);
		
		//redirection vers liste_panier
		modeleDonnees.addAttribute("liste_paniers", panierManager.getAllPanierService());
		
		return "redirect:/panier/liste";
		
	}
	
	@RequestMapping(value="/panier/addProduit", method=RequestMethod.POST)
	public void addProduitPanier(Produit p, int quantite) {
		
	}
}

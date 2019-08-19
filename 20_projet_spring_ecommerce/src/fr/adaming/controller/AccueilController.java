package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@Controller
public class AccueilController {
	
	@Autowired
	private ICategorieService categorieManager;

	// setter pour injection spring
	public void setCategorieManager(ICategorieService categorieManager) {
		this.categorieManager = categorieManager;
	}
	
	@RequestMapping(value = "/accueil")
	public String allerAccueil(ModelMap modelDonnees) {
		
		/*________ Récupération des infos pour la page accueil ___________________*/
		

			//Etape 1 : recupération de la liste des categories depuis la BDD
			List<Categorie> listeCategories = categorieManager.getAllCategories();

			//Etape 2 : Encapsulation de la liste dans l'objet ModelMap
			modelDonnees.addAttribute("liste_categories", listeCategories);


		return "accueil";
	}
}

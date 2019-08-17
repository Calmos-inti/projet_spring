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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@Controller
public class CategorieController {

		@Autowired
		private ICategorieService categorieManager;

		// setter pour injection spring
		public void setCategorieManager(ICategorieService categorieManager) {
			this.categorieManager = categorieManager;
		}

		/* ___________________méthodes gestionnaires_________________________*/
		
		@RequestMapping(value = "/categorie/liste", method = RequestMethod.GET)
		public String listeCategoriesBDD(ModelMap modelDonnees) {

			//Etape 1 : recupération de la liste des categories depuis la BDD
			List<Categorie> listeCategories = categorieManager.getAllCategories();

			//Etape 2 : Encapsulation de la liste dans l'objet ModelMap
			modelDonnees.addAttribute("liste_categories", listeCategories);

			//Etape 3 : Définition du nom logique de la vue
			String nomVue = "liste_des_categories";

			return nomVue;

		} 
	
		@RequestMapping(value = { "/categorie/delete/{pCategorieId}"}, method = RequestMethod.GET)
		public String deleteCategorieBdd(@PathVariable("pCategorieId") int aCategorieId,
				ModelMap modelDonnees) {

			//Etape 1 : suppression de la catégorie depuis la BDD
			categorieManager.deleteCategorie(aCategorieId);
			
			//Etape 2 : recup de la nouvelle liste de catégories et défintion du modèle de données
			List<Categorie> listeCategorieBDD = categorieManager.getAllCategories();
			modelDonnees.addAttribute("liste_categories", listeCategorieBDD);

			// Etape 3 : Renvoi non logique + redirection
			return "redirect:/categorie/liste";

		} 


		@RequestMapping(value = "/addCategorie", method = RequestMethod.GET)
		private ModelAndView setUpFormulaireAjout() {
			
			//Etape 1 : création de l'objet à retourner pour les données
			Map<String, Object> data = new HashMap<String, Object>();
			Categorie categorie = new Categorie();
			
			data.put("categorieCommand", categorie);
			
			// Etape 2 : cration nom logique vue + renvoi du ModelandView
			String nomVue = "ajouter_categorie";
			
			return new ModelAndView(nomVue, data);

		}
		
		@RequestMapping(value="/categorie/add", method=RequestMethod.POST)
		public String addCategorieBdd(@ModelAttribute("categorieCommand") Categorie pCategorie, ModelMap modeleDonnees) {
			
			categorieManager.addCategorie(pCategorie);
			
			//redirection vers liste_fonctionnaires
			modeleDonnees.addAttribute("liste_categories", categorieManager.getAllCategories());
			
			return "redirect:/categorie/liste";
			
		} 
		
		
		@RequestMapping(value="/categorie/updateform", method=RequestMethod.GET)
		public ModelAndView setUpFormulaireUpdate(@RequestParam("fonctId") int pIdFonc) {
			
			//Etape 1 : récupération de la catégorie à modifier (via son ID) 
			Categorie categorieUpdate = categorieManager.getCategorie(pIdFonc);
			
			//Etape 2 : redirection vers la page de modif + Envoi du fonctionnaire  pour modifier la catégorie
			return new ModelAndView("update_categorie", "categorieUpCommand", categorieUpdate);	
		} 
		

		@RequestMapping(value="/categorie/update", method=RequestMethod.POST)
		public String updateFonctionnaireBDD(@ModelAttribute("categorieUpCommand") Categorie categorieUpdate, ModelMap modeleDonnes) {
			
			categorieManager.updateCategorie(categorieUpdate);
			
			// 2. recup de la liste des fonctionnaire dans la bdd
			modeleDonnes.addAttribute("liste_categories", categorieManager.getAllCategories());
			
			return "redirect:/categorie/liste";
			
		}
		
	}




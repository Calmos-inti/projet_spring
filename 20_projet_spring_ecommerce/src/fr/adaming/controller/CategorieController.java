package fr.adaming.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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

		/* ___________________m�thodes gestionnaires_________________________*/
		
		@RequestMapping(value = "/categorie/test")
		public String tester() {

			// ================== TEST AJOUT CATEGORIE =================================
			
			Categorie categorie1 = new Categorie("Chaussettes", null, "les meilleurs chaussettes sur le march�!");
			Categorie categorie2 = new Categorie("Tee-Shirts", null, "les meilleurs tee-shirt sur le march�!");
			Categorie categorie3 = new Categorie("Vestes", null, "les meilleurs vestes sur le march�!");
			categorieManager.addCategorie(categorie1);
			categorieManager.addCategorie(categorie2);
			categorieManager.addCategorie(categorie3);
			return "testProduit";
		}
		
		@RequestMapping(value = "/categorie/liste", method = RequestMethod.GET)
		public String listeCategoriesBDD(ModelMap modelDonnees) {

			//Etape 1 : recup�ration de la liste des categories depuis la BDD
			List<Categorie> listeCategories = categorieManager.getAllCategories();

			//Etape 2 : Encapsulation de la liste dans l'objet ModelMap
			modelDonnees.addAttribute("liste_categories", listeCategories);

			//Etape 3 : D�finition du nom logique de la vue
			String nomVue = "liste_des_categories";

			return nomVue;

		} 
	
		@RequestMapping(value = { "/categorie/delete"}, method = RequestMethod.GET)
		public String deleteCategorieBdd(@RequestParam("idCategorie") int aCategorieId,
				ModelMap modelDonnees) {

			//Etape 1 : suppression de la cat�gorie depuis la BDD
			categorieManager.deleteCategorie(aCategorieId);
			
			//Etape 2 : recup de la nouvelle liste de cat�gories et d�fintion du mod�le de donn�es
			List<Categorie> listeCategorieBDD = categorieManager.getAllCategories();
			modelDonnees.addAttribute("liste_categories", listeCategorieBDD);

			// Etape 3 : Renvoi non logique
			return "accueil";

		} 


		@RequestMapping(value = "/addCategorie", method = RequestMethod.GET)
		private ModelAndView setUpFormulaireAjout() {
			
			//Etape 1 : cr�ation de l'objet � retourner pour les donn�es
			Map<String, Object> data = new HashMap<String, Object>();
			Categorie categorie = new Categorie();
			
			data.put("categorieCommand", categorie);
			
			List<Categorie> listeCategories = categorieManager.getAllCategories();

			data.put("liste_categories", listeCategories);
			
			// Etape 2 : cration nom logique vue + renvoi du ModelandView
			String nomVue = "ajouter_categorie";
			
			return new ModelAndView(nomVue, data);

		}
		
		@RequestMapping(value = "/categorie/add", method = RequestMethod.POST)
		public String addCategorieBdd(
				@RequestParam("photo") MultipartFile photo,
				@RequestParam("designation") String designation,
				@RequestParam("description") String description, ModelMap modelDonnees) throws IOException {

			byte[] photoBytes = photo.getBytes();
			
			Categorie categorie = new Categorie(designation, photoBytes, description);
			
			categorieManager.addCategorie(categorie);
			
			/*______________r�cup�ration des info pour l'accueil______________________________*/
			// Recup�ration de la liste des categories depuis la BDD
			List<Categorie> listeCategories = categorieManager.getAllCategories();

			// Encapsulation de la liste dans l'objet ModelMap
			modelDonnees.addAttribute("liste_categories", listeCategories);

			return "accueil";

		}
		
		
		@RequestMapping(value="/categorie/updateform", method=RequestMethod.GET)
		public String setUpFormulaireUpdate(@RequestParam("idCategorie") int pIdFonc, HttpServletRequest req) {
			
			//Etape 1 : r�cup�ration de la cat�gorie � modifier (via son ID) 
			Categorie categorieUpdate = categorieManager.getCategorie(pIdFonc);
			
			req.setAttribute("categorie", categorieUpdate);
			
			
			return "update_categorie";	
		} 
		

		@RequestMapping(value="/categorie/update", method=RequestMethod.POST)
		public String setUpFormulaireUpdate(
				@RequestParam("photo") MultipartFile photo,
				@RequestParam("nom") String nom,
				@RequestParam("description") String description,
				@RequestParam("idCategorie") Integer id	, ModelMap modelDonnees) throws IOException {
			
			byte[] photoBytes = photo.getBytes();
			
			Categorie categorie = categorieManager.getCategorie(id);
			categorie.setNomCategorie(nom);
			categorie.setDescription(description);
			categorie.setPhoto(photoBytes);
			
			categorieManager.updateCategorie(categorie);
			
			/*______________r�cup�ration des info pour l'accueil______________________________*/
			// Recup�ration de la liste des categories depuis la BDD
			List<Categorie> listeCategories = categorieManager.getAllCategories();

			// Encapsulation de la liste dans l'objet ModelMap
			modelDonnees.addAttribute("liste_categories", listeCategories);
			
			return "accueil";	
		} 
		
	}




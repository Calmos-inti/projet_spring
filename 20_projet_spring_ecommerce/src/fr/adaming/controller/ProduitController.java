package fr.adaming.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller
public class ProduitController {
	@Autowired
	private IProduitService produitManager;

	// setter pour injection spring
	public void setProduitManager(IProduitService produitManager) {
		this.produitManager = produitManager;
	}

	@Autowired
	private ICategorieService categorieManager;

	// setter pour injection spring
	public void setCategorieManager(ICategorieService categorieManager) {
		this.categorieManager = categorieManager;
	}

	/* ___________________méthodes gestionnaires_________________________ */

	@RequestMapping(value = "/produit/test", method = RequestMethod.GET)
	public String tester() {

		// ================== TEST AJOUT CATEGORIE =================================

		Produit produit1 = new Produit("Chaussette bleu", "Chausette 100% coton, confort optimal...", 2, 20, true,
				null);
		produit1.setCategorie(categorieManager.getCategorie(1));

		Produit produit2 = new Produit("Chaussette rouge", "Chausette 100% coton, confort optimal...", 2, 35, true,
				null);
		produit2.setCategorie(categorieManager.getCategorie(1));

		Produit produit3 = new Produit("Chaussette blanche", "Chausette 100% coton, confort optimal...", 2, 50, true,
				null);
		produit3.setCategorie(categorieManager.getCategorie(1));

		Produit produit4 = new Produit("Tee-Shirts bleu", "Tee-Shirts 100% coton, confort optimal...", 10, 40, true,
				null);
		produit4.setCategorie(categorieManager.getCategorie(2));

		Produit produit5 = new Produit("Tee-Shirts blanc", "Tee-Shirts 100% coton, confort optimal...", 20, 35, true,
				null);
		produit5.setCategorie(categorieManager.getCategorie(2));

		Produit produit6 = new Produit("Veste rouge", "Veste 100% coton, confort optimal...", 30, 10, true, null);
		produit6.setCategorie(categorieManager.getCategorie(3));

		Produit produit7 = new Produit("Veste bleu", "Veste 100% coton, confort optimal...", 45, 25, true, null);
		produit7.setCategorie(categorieManager.getCategorie(3));

		produitManager.addProduit(produit1);
		produitManager.addProduit(produit2);
		produitManager.addProduit(produit3);
		produitManager.addProduit(produit4);
		produitManager.addProduit(produit5);
		produitManager.addProduit(produit6);
		produitManager.addProduit(produit7);

		return "testProduit";
	}

	@RequestMapping(value = "/produit/liste", method = RequestMethod.GET)
	public String listeProduitsBDD(ModelMap modelDonnees) {

		// Etape 1 : recupération de la liste des categories depuis la BDD
		List<Produit> listeProduits = produitManager.getAllProduit();

		// Etape 2 : Encapsulation de la liste dans l'objet ModelMap
		modelDonnees.addAttribute("liste_produits", listeProduits);

		// Etape 3 : Définition du nom logique de la vue
		String nomVue = "liste_des_produits";

		return nomVue;

	}

	@RequestMapping(value = { "/produit/delete/{pProduitId}" }, method = RequestMethod.GET)
	public String deleteCategorieBdd(@PathVariable("pProduitId") int aProduitId, ModelMap modelDonnees) {

		// Etape 1 : suppression de la catégorie depuis la BDD
		produitManager.deleteProduit(aProduitId);

		// Etape 2 : recup de la nouvelle liste de catégories et défintion du modèle de
		// données
		List<Produit> listeProduitsBDD = produitManager.getAllProduit();
		modelDonnees.addAttribute("liste_produits", listeProduitsBDD);

		// Etape 3 : Renvoi non logique + redirection
		return "redirect:/produit/liste";

	}

	@RequestMapping(value = "/addProduit", method = RequestMethod.GET)
	private ModelAndView setUpFormulaireAjout(@RequestParam("idCategorie") int pIdCategorie, HttpServletRequest req) {

		// Etape 1 : création de l'objet à retourner pour les données
		Map<String, Object> data = new HashMap<String, Object>();
		Produit produit = new Produit();

		data.put("produitCommand", produit);

		// ajout de le catégorie
		Categorie categorie = categorieManager.getCategorie(pIdCategorie);
		req.setAttribute("categorie", categorie);

		// Etape 2 : cration nom logique vue + renvoi du ModelandView
		String nomVue = "ajouter_produit";

		return new ModelAndView(nomVue, data);

	}

	@RequestMapping(value = "/produit/add", method = RequestMethod.POST)
	public String addCategorieBdd(@RequestParam("photo") MultipartFile photo,
			@RequestParam("designation") String designation, @RequestParam("idCategorie") Integer idCategorie,
			@RequestParam("description") String description, @RequestParam("prix") Double prix,
			@RequestParam("quantite") Integer quantite, ModelMap modelDonnees) throws IOException {

		byte[] photoBytes = photo.getBytes();

		Produit produit = new Produit(designation, description, prix, quantite, true, photoBytes);
		produit.setCategorie(categorieManager.getCategorie(idCategorie));

		produitManager.addProduit(produit);
		
		/*______________récupération des info pour l'accueil______________________________*/
		// Recupération de la liste des categories depuis la BDD
		List<Categorie> listeCategories = categorieManager.getAllCategories();

		// Encapsulation de la liste dans l'objet ModelMap
		modelDonnees.addAttribute("liste_categories", listeCategories);
		
		// Recupération de la liste des produits depuis la BDD
		List<Produit> listeProduit = categorieManager.getCategorie(idCategorie).getListeProduits();

		// Encapsulation de la liste dans l'objet ModelMap
		modelDonnees.addAttribute("liste_produits", listeProduit);
		
		modelDonnees.addAttribute("id_categorie", idCategorie);

		return "accueil_listeProduits";

	}

	@RequestMapping(value = "/updateProduit", method = RequestMethod.GET)
	public String setUpFormulaireUpdate(@RequestParam("idProduit") int pIdFonc, HttpServletRequest req) {

		Produit produitUpdate = produitManager.getProduit(pIdFonc);
		req.setAttribute("produit", produitUpdate);

		return "update_produit";
	}

	@RequestMapping(value = "/produit/update", method = RequestMethod.POST)
	public String setUpFormulaireUpdate(@RequestParam("photo") MultipartFile photo,
			@RequestParam("nom") String designation,
			@RequestParam("description") String description, @RequestParam("prix") Double prix,
			@RequestParam("quantite") Integer quantite,
			@RequestParam("idProduit") Integer id, ModelMap modelDonnees) throws IOException {
		
		byte[] photoBytes = photo.getBytes();
		
		Produit produit = produitManager.getProduit(id);
	
		produit.setDesignation(designation);
		produit.setDescription(description);
		produit.setPhoto(photoBytes);
		produit.setPrix(prix);
		produit.setQuantite(quantite);
		
		produitManager.updateProduit(produit);
		
		List<Categorie> listeCategories = categorieManager.getAllCategories();
		
		modelDonnees.addAttribute("liste_categories", listeCategories);
				
		// Recupération de la liste des produits depuis la BDD
		List<Produit> listeProduits = produitManager.getAllProduit();

		// Encapsulation de la liste dans l'objet ModelMap
		modelDonnees.addAttribute("liste_produits", listeProduits);
		
		return "accueil";

	}
}

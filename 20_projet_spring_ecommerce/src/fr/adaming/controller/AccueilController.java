package fr.adaming.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IProduitService;

@Controller
public class AccueilController {

	/* _____________ liaison avec la couche service ________________ */
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

	@Autowired
	private IClientService clientService;

	// setter pour injection spring
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}
	
	

	/* ___________________________ Méthodes métiers ________________________ */

	public void infoMenuGauche(ModelMap modelDonnees) {

		// Recupération de la liste des categories depuis la BDD
		List<Categorie> listeCategories = categorieManager.getAllCategories();

		// Encapsulation de la liste dans l'objet ModelMap
		modelDonnees.addAttribute("liste_categories", listeCategories);

	}
	
	public Client recuperationClientConnecte() {
		try {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String mail = auth.getName();

		return clientService.getClientbyMailService(mail);}
		catch (Exception e) {
			return null;
		}
	}
	
	public void infoPanier(ModelMap modelDonnees) {
		
		Client client = recuperationClientConnecte();
		
		if(client!=null) {
		// récupération du panier actif 
		List<Panier> listPanier = client.getListePanier();
		Panier panier = client.getListePanier().get(listPanier.size()-1);
		
		// Encapsulation de la liste dans l'objet ModelMap
		modelDonnees.addAttribute("panier", panier);
		}
		
	}
	
	

	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String allerAccueil(ModelMap modelDonnees) {

		/* ________ Récupération des infos pour la page accueil ___________________ */

		infoMenuGauche(modelDonnees);
		infoPanier(modelDonnees);
		
		return "accueil";
	}

	@RequestMapping(value = "/accueil/liste_produit", method = RequestMethod.GET)
	public String listerProduits(@RequestParam("idCategorie") int pIdCategorie, ModelMap modelDonnees, Model model) {

		infoMenuGauche(modelDonnees);
		infoPanier(modelDonnees);
		
		// Recupération de la liste des produits depuis la BDD
		List<Produit> listeProduit = categorieManager.getCategorie(pIdCategorie).getListeProduits();

		// Etape 2 : Encapsulation de la liste dans l'objet ModelMap
		modelDonnees.addAttribute("liste_produits", listeProduit);
		modelDonnees.addAttribute("id_categorie", pIdCategorie);
		
		model.addAttribute("produitCommand", new Produit()); 
		
		return "accueil_listeProduits";
	}

	@RequestMapping(value = "/accueil/produit", method = RequestMethod.GET)
	public String rechercheProduitsbyId(@RequestParam("idProduit") int pIdProduit, ModelMap modelDonnees, Model model) {

		infoMenuGauche(modelDonnees);
		infoPanier(modelDonnees);
		
		// Recupération de la liste des produits depuis la BDD
		Produit produit = produitManager.getProduit(pIdProduit);

		List<Produit> listeProduit = new ArrayList<>();
		listeProduit.add(produit);

		// Etape 2 : Encapsulation de la liste dans l'objet ModelMap
		modelDonnees.addAttribute("liste_produits", listeProduit);
		
		model.addAttribute("produitCommand", new Produit());
		
		return "accueil_listeProduits";
	}

	@RequestMapping(value = "/accueil/recherche", method = RequestMethod.GET)
	public String rechercheProduitsMotCle(@RequestParam("mot") String pMot, ModelMap modelDonnees, Model model) {

		infoMenuGauche(modelDonnees);
		infoPanier(modelDonnees);
		
		List<Produit> listeProduit = produitManager.getAllProduit();
		List<Produit> listeRecherche = new ArrayList<>();

		// StringTokenizer st = new StringTokenizer(pMot);
		//
		// while (st.hasMoreTokens()) {

		for (Produit produit : listeProduit) {

			if (produit.getDesignation().toUpperCase().contains(pMot.toUpperCase())) {
				listeRecherche.add(produit);
			} else if (produit.getDescription().toUpperCase().contains(pMot.toUpperCase())) {
				listeRecherche.add(produit);
			}
		}
		// }

		int nombreTrouve = listeRecherche.size();

		modelDonnees.addAttribute("liste_produits", listeRecherche);
		modelDonnees.addAttribute("nombre_trouve", nombreTrouve);
		modelDonnees.addAttribute("mot_cle", pMot);
		
		model.addAttribute("produitCommand", new Produit());
		
		return "accueil_listeProduits";
	}

	@RequestMapping(value = "/accueil/creerCompte", method = RequestMethod.GET)
	public ModelAndView formulaireAddClient() {
		
		// Etape 1 : création de l'objet à retourner pour les données
		Map<String, Object> data = new HashMap<String, Object>();
		Client client = new Client();

		data.put("clientCommand", client);

		// Etape 2 : cration nom logique vue + renvoi du ModelandView
		String nomVue = "formulaire_ajoutClient";

		return new ModelAndView(nomVue, data);
	}

	@RequestMapping(value = "/accueil/ajouterClient", method = RequestMethod.POST)
	public String AddClient(@ModelAttribute("clientCommand") Client pClient, ModelMap modeleDonnees, HttpServletRequest request) {
		
		// récupération des infos pour le menu gauche
		infoMenuGauche(modeleDonnees);
		infoPanier(modeleDonnees);
		
		pClient.setEnabled(true);
		clientService.addClientService(pClient);
	
		modeleDonnees.addAttribute("nom_client", pClient.getNom());
			
		// Auto connexion
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
        Authentication authentication = new UsernamePasswordAuthenticationToken(pClient.getMail(), pClient.getPassword(), authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
	    return "accueil";
	}
	
	@RequestMapping(value = "/accueil_backoffice", method = RequestMethod.GET)
	public String allerAccueilBackOffice (ModelMap modelDonnees) {

		infoMenuGauche(modelDonnees);

		return "accueil_backoffice";
	}
	

}

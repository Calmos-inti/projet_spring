package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Commande;
import fr.adaming.model.LignePanier;
import fr.adaming.model.Produit;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICommandeService;
import fr.adaming.service.ILignePanierService;
import fr.adaming.service.IPanierService;
import fr.adaming.service.IProduitService;

@Controller
public class LignePanierController {
	
	@Autowired
	private ICommandeService commandeService;
	
	// setters
	public void setCommandeService(ICommandeService commandeService) {
		this.commandeService = commandeService;
	}


	@Autowired
	private IClientService clServ;

	// setters
	public void setClServ(ClientServiceImpl clServ) {
		this.clServ = clServ;
	}
	
	
	@Autowired
	private ILignePanierService lignePanierManager;

	
	//setter
	
	public void setLignePanierManager(ILignePanierService lignePanierManager) {
		this.lignePanierManager = lignePanierManager;
	}
	
	@Autowired
	private IPanierService panierManager;
	
	//setter pour injection spring

	public void setPanierManager(IPanierService panierManager) {
		this.panierManager = panierManager;
	}
	
	@Autowired
	private IProduitService produitManager;

	// setter pour injection spring
	public void setProduitManager(IProduitService produitManager) {
		this.produitManager = produitManager;
	}
	
	/* _____________________ TESTS LIGNE PANIER________________________________ */
	
	@RequestMapping(value="/ligne_panier/test")
	public String tester() {
		
		
		Produit produit1 = produitManager.getProduit(1);
		Produit produit2 = produitManager.getProduit(2);
		Produit produit3 = produitManager.getProduit(3);
		Produit produit4 = produitManager.getProduit(4);
		
		
		LignePanier lp1 = new LignePanier();
		lp1.setProduit(produit1);
		lp1.setQuantité(1);
		lp1.setPanier(panierManager.getPanierService(1));
		
		LignePanier lp2 = new LignePanier();
		lp2.setProduit(produit2);
		lp2.setQuantité(2);
		lp2.setPanier(panierManager.getPanierService(1));
		
		LignePanier lp3 = new LignePanier();
		lp3.setProduit(produit3);
		lp3.setQuantité(3);
		lp3.setPanier(panierManager.getPanierService(2));
		
		LignePanier lp4 = new LignePanier();
		lp4.setProduit(produit4);
		lp4.setQuantité(4);
		lp4.setPanier(panierManager.getPanierService(3));
		
		
		lignePanierManager.addLignePanierService(lp1);
		lignePanierManager.addLignePanierService(lp2);
		lignePanierManager.addLignePanierService(lp3);
		lignePanierManager.addLignePanierService(lp4);
		
		return "testProduit";
	}
	
	@RequestMapping(value="/commande/test")
	public String testerCommande() {
		
		
		Produit produit1 = produitManager.getProduit(1);
		Produit produit2 = produitManager.getProduit(2);
		Produit produit3 = produitManager.getProduit(3);
		Produit produit4 = produitManager.getProduit(4);
		
		
		LignePanier lp1 = new LignePanier();
		lp1.setProduit(produit1);
		lp1.setQuantité(1);
		lp1.setPanier(panierManager.getPanierService(5));
		
		LignePanier lp2 = new LignePanier();
		lp2.setProduit(produit2);
		lp2.setQuantité(2);
		lp2.setPanier(panierManager.getPanierService(5));
		
		LignePanier lp3 = new LignePanier();
		lp3.setProduit(produit3);
		lp3.setQuantité(3);
		lp3.setPanier(panierManager.getPanierService(5));
		
		LignePanier lp4 = new LignePanier();
		lp4.setProduit(produit4);
		lp4.setQuantité(4);
		lp4.setPanier(panierManager.getPanierService(5));
		
		lp1=lignePanierManager.getLignePanierService(lignePanierManager.addLignePanierService(lp1));
		lp2=lignePanierManager.getLignePanierService(lignePanierManager.addLignePanierService(lp2));
		lp3=lignePanierManager.getLignePanierService(lignePanierManager.addLignePanierService(lp3));
		lp4=lignePanierManager.getLignePanierService(lignePanierManager.addLignePanierService(lp4));
		
		
		Commande commande1 = new Commande();
		commande1.setValider(false);
		commande1.setClient(clServ.getClientService(5));
		commande1 = commandeService.getCommandeService(commandeService.addCommandeService(commande1));
		
		lignePanierManager.ajouterLignePanierDansCommandeBDD(lp1, commande1);
		lignePanierManager.ajouterLignePanierDansCommandeBDD(lp2, commande1);
		
		
		Commande commande2 = new Commande();
		commande2.setValider(false);
		commande2.setClient(clServ.getClientService(5));
		commande2 = commandeService.getCommandeService(commandeService.addCommandeService(commande2));
		lignePanierManager.ajouterLignePanierDansCommandeBDD(lp3, commande2);
		
		Commande commande3 = new Commande();
		commande3.setValider(false);
		commande3.setClient(clServ.getClientService(5));
		commande3 = commandeService.getCommandeService(commandeService.addCommandeService(commande3));
		lignePanierManager.ajouterLignePanierDansCommandeBDD(lp4, commande3);
			
		return "testProduit";
	}
	
	
		
		@RequestMapping(value = "/ligne_panier/liste", method = RequestMethod.GET)
		public String listeLignePaniersBDD(ModelMap modelDonnees) {
			
			//Etape 1 : recupération de la liste des lignes paniers depuis la BDD
			List<LignePanier> listeLignePaniers = lignePanierManager.getAllLignePanierService();
			
			//Etape 2 : Encapsulation de la liste dans l'objet ModelMap
			modelDonnees.addAttribute("liste_lignePaniers", listeLignePaniers);
			
			//Etape 3 : Définition du nom logique de la vue
			String nomVue = "liste_des_lignePaniers";

			return nomVue;
			
			
		}
		
		@RequestMapping(value = { "/ligne_panier/delete/{pLignePanierId}"}, method = RequestMethod.GET)
		public String deleteLignePanierBDD(@PathVariable("pLignePanierId") int aLignePanierId,
				ModelMap modelDonnees) {
			
			//Etape 1 : suppression de la lignepanier depuis la BDD
			lignePanierManager.deleteLignePanierService(aLignePanierId);
			
			//Etape 2 : recup de la nouvelle liste de ligne panier et défintion du modèle de données
			List<LignePanier> listeLignePanierBDD = lignePanierManager.getAllLignePanierService();
			modelDonnees.addAttribute("liste_lignePaniers", listeLignePanierBDD);

			// Etape 3 : Renvoi non logique + redirection
			return "redirect:/ligne_panier/liste";
		}
		
		//lappli ne se lance pas
		
			
	}
	
	
	



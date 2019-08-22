package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.LignePanier;
import fr.adaming.service.ILignePanierService;
import fr.adaming.service.IPanierService;

@Controller
public class LignePanierController {
	
	
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
	
	
	/* _____________________ TESTS LIGNE PANIER________________________________ */
	
	@RequestMapping(value="/ligne_panier/test")
	public String tester() {
		
		LignePanier lp1 = new LignePanier();
		lp1.setPanier(panierManager.getPanierService(1));
		LignePanier lp2 = new LignePanier();
		lp2.setPanier(panierManager.getPanierService(2));
		LignePanier lp3 = new LignePanier();
		lp3.setPanier(panierManager.getPanierService(3));
//		LignePanier lp4 = new LignePanier(3, null);
//		lp1.setPanier(panierManager.getPanierService(1));
		
		lignePanierManager.addLignePanierService(lp1);
		lignePanierManager.addLignePanierService(lp2);
		lignePanierManager.addLignePanierService(lp3);
//		lignePanierManager.addLignePanierService(lp4);
		
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
	
	
	



package fr.adaming.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LignePanier;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.model.Role;
import fr.adaming.model.User;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICommandeService;
import fr.adaming.service.ILignePanierService;
import fr.adaming.service.IPanierService;
import fr.adaming.service.IProduitService;
import fr.adaming.service.IRoleService;
import fr.adaming.service.IUserService;
import fr.adaming.service.UserServiceImpl;

@Controller
public class ClientController {

	/* _____________ liaison avec la couche service ________________ */
	@Autowired
	private ICategorieService categorieManager;

	// setter pour injection spring
	public void setCategorieManager(ICategorieService categorieManager) {
		this.categorieManager = categorieManager;
	}

	@Autowired
	private IClientService clServ;

	// setters
	public void setClServ(ClientServiceImpl clServ) {
		this.clServ = clServ;
	}

	@Autowired
	private IUserService userServ;

	// setters
	public void setUserServ(UserServiceImpl userServ) {
		this.userServ = userServ;
	}

	@Autowired
	IRoleService roleService;

	// setters
	public void setRoleDao(IRoleService roleService) {
		this.roleService = roleService;
	}

	@Autowired
	private IProduitService produitManager;

	// setter pour injection spring
	public void setProduitManager(IProduitService produitManager) {
		this.produitManager = produitManager;
	}

	@Autowired
	private ILignePanierService lignePanierManager;

	// setter
	public void setLignePanierManager(ILignePanierService lignePanierManager) {
		this.lignePanierManager = lignePanierManager;
	}

	@Autowired
	private IPanierService panierManager;

	// setter pour injection spring

	public void setPanierManager(IPanierService panierManager) {
		this.panierManager = panierManager;
	}

	@Autowired
	private ICommandeService commandeService;

	// setters
	public void setCommandeService(ICommandeService commandeService) {
		this.commandeService = commandeService;
	}
	/* _________________ TESTS CLIENT ET USER (à supprimer)_______________ */

	@RequestMapping(value = "/test33", method = RequestMethod.GET)
	public String testttte(ModelMap modeleDonnes) {

		Client client = recuperationClientConnecte();

		List<Commande> listeCommande = client.getListeCommandes();

		modeleDonnes.addAttribute("liste_commandes", listeCommande);

		System.out.println("------------------TEST------------------------");

		for (Commande command : listeCommande) {
			System.out.println("boucle commande");
			System.out.println("\t> Commande id :" + command.getId());
			System.out.println("\t> Commande total :" + command.getTotal());

			List<LignePanier> list = command.getListeLignePanier();

			for (LignePanier lp : list) {
				System.out.println("boucle lp");
				System.out.println("\t\t> Ligne panier id :" + lp.getId());
				System.out.println("\t\t> Ligne panier prix :" + lp.getPrix());
			}

		}

		System.out.println("-----------------FIN TEST------------------------");
		return "testClient";
	} // end afficherCommandes

	@RequestMapping(value = "/client/test")
	public String tester() {

		// ================== TEST AJOUT CLIENT =================================
		Client client1 = new Client("client1@mail.com", "1111", true, "toto", "12 rue des pins", "0678596258");
		Client client2 = new Client("client2@mail.com", "2222", true, "titi", "12 rue des chênes", "0589751523");
		Client client3 = new Client("client3@mail.com", "3333", true, "fifi", "12 rue des sapins", "0656239048");
		Client client4 = new Client("client4@mail.com", "4444", true, "coco", "12 rue des peupliers", "0601892365");
		Client superAdmin = new Client("a@a", "a", true, "Super Admin", "48 rue des tomates", "0675624512");

		clServ.addClientService(client1);
		clServ.addClientService(client2);
		clServ.addClientService(client3);
		clServ.addClientService(client4);

		int idSuperAdmin = clServ.addClientService(superAdmin);

		Role role1 = new Role();
		role1.setRoleName("ROLE_PRODUIT");
		role1.setUser(clServ.getClientService(idSuperAdmin));
		roleService.addRoleService(role1);

		Role role2 = new Role();
		role2.setRoleName("ROLE_CATEGORIE");
		role2.setUser(clServ.getClientService(idSuperAdmin));
		roleService.addRoleService(role2);

		// ================== TEST GET CLIENT =================================

		Client clientFind = clServ.getClientService(1);

		System.out.println("---------------------get by id 1-------------------");
		System.out.println("> Client à l'id 1: " + clientFind);
		System.out.println("---------------------------------------------------");

		// ================== TEST GET CLIENT =================================

		Client clientFind2 = clServ.getClientbyMailService(superAdmin.getMail());

		System.out.println("---------------------get by mail ------------------");
		System.out.println("> Client avec le mail a@a: " + clientFind2);
		System.out.println("---------------------------------------------------");

		// ================== TEST GETALL CLIENT =================================

		List<Client> listeClient = clServ.getAllClientService();

		System.out.println("---------------------get all-------------------");
		for (Client client : listeClient) {
			System.out.println("> " + client);
		}
		System.out.println("---------------------------------------------------");

		// ================== TEST DELETE CLIENT =================================
		// clServ.deleteClientService(2);
		//
		// System.out.println("---------------------delete (id 2)-------------------");
		// Client clientFind2 = clServ.getClientService(2);
		//
		// System.out.println("---------------------get by id 2-------------------");
		// System.out.println("> Client à l'id 2: " + clientFind2);
		// System.out.println("---------------------------------------------------");

		// ================== TEST UPDATE CLIENT =================================

		Client clientFind3 = clServ.getClientService(3);

		System.out.println("---------------------update (id 3) nom = 'Jean'-------------------");
		clientFind3.setNom("Jean");
		clServ.updateClientService(clientFind3);

		System.out.println("---------------------get by id 3-------------------");
		System.out.println("> Client à l'id 3: " + clientFind3);
		System.out.println("---------------------------------------------------");

		// ================== TEST CLIENT 1 =================================
		Client clientout = clServ.getClientService(1);

		System.out.println("-----------------TEST : client 1-------------------");
		System.out.println("> mail client 1 : " + clientout.getMail());
		System.out.println("---------------------------------------------------");

		List<Role> listRole = clientout.getListeRoles();

		System.out.println("---------------------role client id=1-------------------");
		for (Role role : listRole) {
			System.out.println("> " + role);
		}
		System.out.println("---------------------------------------------------");

		// ================== TEST AJOUT USER =================================
		User user1 = new User("user1@mail.com", "admin", true);
		User user2 = new User("user2@mail.com", "admin", true);
		User user3 = new User("user3@mail.com", "admin", true);
		User user4 = new User("user4@mail.com", "admin", true);

		userServ.addUserService(user1);
		userServ.addUserService(user2);
		userServ.addUserService(user3);
		userServ.addUserService(user4);

		// ================== TEST GET USER =================================

		User userFind5 = userServ.getUserService(5);

		System.out.println("---------------------get by id 5-------------------");
		System.out.println("> User à l'id 5: " + userFind5);
		System.out.println("---------------------------------------------------");

		// ================== TEST GETALL USER =================================

		List<User> listeUser = userServ.getAllUserService();

		System.out.println("---------------------get all-------------------");
		for (User user : listeUser) {
			System.out.println("> " + user);
		}
		System.out.println("---------------------------------------------------");

		// ================== TEST DELETE USER =================================
		// userServ.deleteUserService(6);
		//
		// System.out.println("---------------------delete (id 6)-------------------");
		// User userFind6 = userServ.getUserService(6);
		//
		// System.out.println("---------------------get by id 6-------------------");
		// System.out.println("> User à l'id 6: " + userFind6);
		// System.out.println("---------------------------------------------------");

		// ================== TEST UPDATE USER =================================

		User userFind7 = userServ.getUserService(7);

		System.out.println("---------------------update (id 7) mail = 'jean@mail.com'-------------------");
		userFind7.setMail("jean@mail.com");
		userServ.updateUserService(userFind7);

		System.out.println("---------------------get by id 3-------------------");
		System.out.println("> User à l'id 3: " + userFind7);
		System.out.println("---------------------------------------------------");

		return "testClient";
	}

	/* _____________ méthodes utilitaires ________________ */

	public void infoMenuGauche(ModelMap modelDonnees) {

		// Recupération de la liste des categories depuis la BDD
		List<Categorie> listeCategories = categorieManager.getAllCategories();

		// Encapsulation de la liste dans l'objet ModelMap
		modelDonnees.addAttribute("liste_categories", listeCategories);

	}

	public Client recuperationClientConnecte() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String mail = auth.getName();

		return clServ.getClientbyMailService(mail);
	}

	public void infoPanier(ModelMap modelDonnees) {

		Client client = recuperationClientConnecte();

		// récupération du panier actif
		List<Panier> listPanier = client.getListePanier();
		Panier panier = client.getListePanier().get(listPanier.size() - 1);

		// Encapsulation de la liste dans l'objet ModelMap
		modelDonnees.addAttribute("panier", panier);

	}

	/* _____________ méthodes d'interseption de requetes ________________ */

	@RequestMapping(value = "/client/formulaireUpdate", method = RequestMethod.GET)
	public ModelAndView miseEnPlaceFormulaireUpdate() {

		// Création de l'objet à retourner pour les données
		Map<String, Object> data = new HashMap<String, Object>();
		Client client = recuperationClientConnecte();

		data.put("clientCommandUpadate", client);

		String nomVue = "update_client";

		return new ModelAndView(nomVue, data);
	}// end miseEnPlaceFormulaireUpdate

	@RequestMapping(value = "/client/updateClient", method = RequestMethod.POST)
	public String UpdateClient(@ModelAttribute("clientCommandUpadate") Client client, ModelMap modeleDonnes) {

		clServ.updateClientService(client);
		infoMenuGauche(modeleDonnes);
		infoPanier(modeleDonnes);


		return "accueil";
	} // end UpdateClient

	@RequestMapping(value = "/client/afficherCommandes", method = RequestMethod.GET)
	public String afficherCommandes(ModelMap modeleDonnes) {

		Client client = recuperationClientConnecte();

		List<Commande> listeCommande = client.getListeCommandes();

		modeleDonnes.addAttribute("liste_commandes", listeCommande);
		infoPanier(modeleDonnes);

		return "commandes_client";
	} // end afficherCommandes

	@RequestMapping(value = "/client/ajoutPanier", method = RequestMethod.POST)
	public String ajoutPanier(@ModelAttribute("produitCommand") Produit produit, ModelMap modeleDonnes) {

		int quantite = produit.getQuantite();

		Produit produitOut = produitManager.getProduit(produit.getIdProduit());

		// récupération du client connecté
		Client client = recuperationClientConnecte();
		
		// récupération du panier actif
		List<Panier> listPanier = client.getListePanier();
		int size = listPanier.size();
		Panier panier= client.getListePanier().get(size - 1);

		// Calcul de la nouvelle quantité de produit + envoi dans la bdd
		produitOut.setQuantite(produitOut.getQuantite() - quantite);
		produitManager.updateProduit(produitOut);

		// création de la ligne de panier
		LignePanier lignePanier = new LignePanier();
		lignePanier.setProduit(produitOut);
		lignePanier.setQuantite(quantite);
		
		// ajout de la ligne au panier
		lignePanier.setPanier(panier);

		// ajout de la ligne dans la bdd
		lignePanierManager.addLignePanierService(lignePanier);
		
		// récupérer le panier à jour
		panier=panierManager.getPanierService(panier.getId());
		
		// Calcul du total du panier
		double total = 0.0;
		for (LignePanier lp : panier.getListeLignePanier()) {
			total = total + lp.getPrix();
		}
		panier.setTotal(total);
		panierManager.updatePanierService(panier);

		// mise à jour du menu gauche
		infoMenuGauche(modeleDonnes);
		infoPanier(modeleDonnes);

		// redirection
		return "accueil";
	} // end ajoutPanier

	@RequestMapping(value = "/client/validerPanier", method = RequestMethod.GET)
	public String validerPanier(ModelMap modeleDonnes) {

		// récupération du client connecté
		Client client = recuperationClientConnecte();

		// récupération des lignes du panier actif
		List<Panier> listPanier = client.getListePanier();
		int size = listPanier.size();
		List<LignePanier> listeLignePanier = client.getListePanier().get(size - 1).getListeLignePanier();

		// Création d'une commande avec ces listes
		Commande commande = new Commande();
		commande.setValider(false);
		commande.setClient(clServ.getClientService(client.getId()));
		commande = commandeService.getCommandeService(commandeService.addCommandeService(commande));

		// ajout de la liste de ligne de panier à la commande
		for (LignePanier lignePanier : listeLignePanier) {
			lignePanierManager.ajouterLignePanierDansCommandeBDD(lignePanier, commande);
		}

		// Création du nouveau panier
		Panier panier = new Panier();
		panier.setClient(client);
		panierManager.addPanierService(panier);

		// mise à jour du menu gauche
		infoMenuGauche(modeleDonnes);
		infoPanier(modeleDonnes);

		return "accueil";
	}
} // end class

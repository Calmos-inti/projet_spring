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
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.User;
import fr.adaming.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userManager;

	// setter pour injection spring
	public void setUserManager(IUserService userManager) {
		this.userManager = userManager;
	}

	
	// methodes
	@RequestMapping(value = "/user/liste", method = RequestMethod.GET)
	public String listeUsersBDD(ModelMap modelDonnees) {

		//Etape 1 : recupération de la liste des categories depuis la BDD
		List<User> listeUsers = userManager.getAllUserService();

		//Etape 2 : Encapsulation de la liste dans l'objet ModelMap
		modelDonnees.addAttribute("liste_users", listeUsers);

		//Etape 3 : Définition du nom logique de la vue
		String nomVue = "accueil_users";

		return nomVue;

	} 

	@RequestMapping(value = { "/user/delete"}, method = RequestMethod.GET)
	public String deleteCategorieBdd(@RequestParam("idUser") int aUserId,
			ModelMap modelDonnees) {

		//Etape 1 : suppression de la catégorie depuis la BDD
		userManager.deleteUserService(aUserId);
		
		//Etape 2 : recup de la nouvelle liste de catégories et défintion du modèle de données
		List<User> listeUsers = userManager.getAllUserService();
		modelDonnees.addAttribute("liste_users", listeUsers);

		// Etape 3 : Renvoi non logique
		return "accueil_users";

	} 


	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	private ModelAndView setUpFormulaireAjout() {
		
		//Etape 1 : création de l'objet à retourner pour les données
		Map<String, Object> data = new HashMap<String, Object>();
		User user = new User();
		
		data.put("userCommand", user);
		
		List<User> listeUsers = userManager.getAllUserService();
		data.put("liste_users", listeUsers);
		
		// Etape 2 : cration nom logique vue + renvoi du ModelandView
		String nomVue = "ajouter_user";
		
		return new ModelAndView(nomVue, data);

	}
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUserBdd(
			@RequestParam("mail") String mail,
			@RequestParam("password") String password,
//			@RequestParam("adresse") String adresse,
//			@RequestParam("nom") String nom,
//			@RequestParam("telephone") String telephone,
			ModelMap modelDonnees) throws IOException {

		
		
		User user = new User(mail, password, true);
		
		userManager.addUserService(user);
		
		/*______________récupération des info pour l'accueil______________________________*/
		// Recupération de la liste des categories depuis la BDD
		List<User> listeUsers = userManager.getAllUserService();
		modelDonnees.addAttribute("liste_users", listeUsers);

		return "accueil_users";

	}
	
	
	@RequestMapping(value="/user/updateform", method=RequestMethod.GET)
	public String setUpFormulaireUpdate(@RequestParam("idUser") int pIdUser, HttpServletRequest req) {
		
		//Etape 1 : récupération de la catégorie à modifier (via son ID) 
		User userUpdate = userManager.getUserService(pIdUser);
		
		req.setAttribute("user", userUpdate);
		
		
		return "update_user";	
	} 
	

	@RequestMapping(value="/user/update", method=RequestMethod.POST)
	public String setUpFormulaireUpdate(
			@RequestParam("mail") String mail,
			@RequestParam("password") String password,
//			@RequestParam("adresse") String adresse,
//			@RequestParam("nom") String nom,
//			@RequestParam("telephone") String telephone,
			@RequestParam("id") Integer id	, ModelMap modelDonnees) throws IOException {
		
		
		User user = userManager.getUserService(id);
		user.setMail(mail);
		user.setPassword(password);
		
		userManager.updateUserService(user);
		
		/*______________récupération des info pour l'accueil______________________________*/
		// Recupération de la liste des categories depuis la BDD
		List<User> listeUsers = userManager.getAllUserService();
		modelDonnees.addAttribute("liste_users", listeUsers);
		
		return "accueil_users";	
	} 
		

}



		
	
		
		





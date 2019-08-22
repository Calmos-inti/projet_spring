package fr.adaming.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Caroussel;
import fr.adaming.model.Categorie;
import fr.adaming.service.ICarousselService;

@Controller
public class CarousselController {

	@Autowired
	private ICarousselService carousselManager;
	
	public void setCarousselManager(ICarousselService carousselManager) {
		this.carousselManager = carousselManager;
	}
	
	@RequestMapping(value = "/caroussel/liste", method = RequestMethod.GET)
	public String listeCarousselsBDD(ModelMap modelDonnees) {

		//Etape 1 : recupération de la liste des categories depuis la BDD
		List<Caroussel> listeCaroussels = carousselManager.getAllCarousselService();

		//Etape 2 : Encapsulation de la liste dans l'objet ModelMap
		modelDonnees.addAttribute("liste_caroussels", listeCaroussels);

		//Etape 3 : Définition du nom logique de la vue
		String nomVue = "liste_des_caroussels";

		return nomVue;

	} 

	@RequestMapping(value = { "/caroussel/delete"}, method = RequestMethod.GET)
	public String deleteCarousselBdd(@RequestParam("idCaroussel") int aCarousselId,
			ModelMap modelDonnees) {

		//Etape 1 : suppression de la catégorie depuis la BDD
		carousselManager.deleteImageService(aCarousselId);
		
		List<Caroussel> listeCarousselsBDD = carousselManager.getAllCarousselService();
		modelDonnees.addAttribute("liste_caroussels", listeCarousselsBDD);
		
		// Etape 3 : Renvoi nom logique
		return "redirect:/caroussel/liste";

	} 
	
	@RequestMapping(value = "/addCaroussel", method = RequestMethod.GET)
	private ModelAndView setUpFormulaireAjout() {
		
		Map<String, Object> data = new HashMap<String, Object>();
		Caroussel caroussel = new Caroussel();
		
		data.put("carousselCommand", caroussel);
		
		// Etape 2 : cration nom logique vue + renvoi du ModelandView
		String nomVue = "ajouter_caroussel";
		
		return new ModelAndView(nomVue, data);

	}
	
	@RequestMapping(value = "/caroussel/add", method = RequestMethod.POST)
	public String addCarousselBdd(
			@RequestParam("photo") MultipartFile photo,
			@RequestParam("photo2") MultipartFile photo2,
			@RequestParam("photo3") MultipartFile photo3, ModelMap modelDonnees) throws IOException {

		byte[] photoBytes = photo.getBytes();
		byte[] photoBytes2 = photo2.getBytes();
		byte[] photoBytes3 = photo3.getBytes();
		
		Caroussel caroussel = new Caroussel(photoBytes, photoBytes2, photoBytes3);
		
		carousselManager.addImageService(caroussel);
		
		List<Caroussel> listeCaroussels = carousselManager.getAllCarousselService();

		modelDonnees.addAttribute("liste_caroussels", listeCaroussels);
		
		return "redirect:/caroussel/liste";

	}
	
	
	
}

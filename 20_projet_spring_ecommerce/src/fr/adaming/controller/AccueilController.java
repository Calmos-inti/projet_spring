package fr.adaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccueilController {
	
	@RequestMapping(value = "/accueil")
	public String allerAccueil() {
		
		/*________ Récupération des infos pour la page accueil ___________________*/
		
		// à faire
		
		return "accueil";
	}
}

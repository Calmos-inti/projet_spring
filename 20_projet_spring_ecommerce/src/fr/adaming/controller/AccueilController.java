package fr.adaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccueilController {
	
	@RequestMapping(value = "/accueil")
	public String allerAccueil() {
		
		/*________ R�cup�ration des infos pour la page accueil ___________________*/
		
		// � faire
		
		return "accueil";
	}
}

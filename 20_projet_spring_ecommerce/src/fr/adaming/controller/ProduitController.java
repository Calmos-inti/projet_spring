package fr.adaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProduitController {
	
	@RequestMapping(value = "/produit/test")
	public String tester(Model model) {
		
		
		return "testProduit";
	}

}

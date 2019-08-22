package fr.adaming.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.adaming.model.Caroussel;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICarousselService;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/myImage")
public class ImageController {

	@Autowired
	private ICategorieService categorieService;

	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}

	@Autowired
	private IProduitService produitService;

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}
	
	@Autowired
	private ICarousselService carousselService;
	
	public void setCarousselService(ICarousselService carousselService) {
		this.carousselService = carousselService;
	}

	@RequestMapping(value = "/imageCategorieDisplay", method = RequestMethod.GET)
	public void showImage(@RequestParam("id") int itemId, HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {

		Categorie categorie = categorieService.getCategorie(itemId);

		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(categorie.getPhoto());
		response.getOutputStream().close();
	}

	@RequestMapping(value = "/imageProduitDisplay", method = RequestMethod.GET)
	public void show2Image(@RequestParam("id") int itemId, HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {

		Produit produit = produitService.getProduit(itemId);

		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(produit.getPhoto());
		response.getOutputStream().close();
	}
	
	@RequestMapping(value = "/image1CarousselDisplay", method = RequestMethod.GET)
	public void carousselImage1(@RequestParam("id") int itemId, HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {

		Caroussel caroussel = carousselService.getCarousselService(itemId);

		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(caroussel.getPhoto());
		response.getOutputStream().close();
	}
	
	@RequestMapping(value = "/image2CarousselDisplay", method = RequestMethod.GET)
	public void carousselImage2(@RequestParam("id") int itemId, HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {

		Caroussel caroussel = carousselService.getCarousselService(itemId);

		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(caroussel.getPhoto2());
		response.getOutputStream().close();
	}
	
	@RequestMapping(value = "/image3CarousselDisplay", method = RequestMethod.GET)
	public void carousselImage3(@RequestParam("id") int itemId, HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {

		Caroussel caroussel = carousselService.getCarousselService(itemId);

		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(caroussel.getPhoto3());
		response.getOutputStream().close();
	}

}
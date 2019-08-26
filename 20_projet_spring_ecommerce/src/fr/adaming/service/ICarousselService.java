package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Caroussel;

public interface ICarousselService {
	
public int addImageService(Caroussel caroussel);
	
	public void deleteImageService(int pIdCaroussel);
	
	public List<Caroussel> getAllCarousselService();
	
	public Caroussel getCarousselService (int pIdCaroussel);
	
	public void updateImageService (Caroussel caroussel);

}

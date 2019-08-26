package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Caroussel;

public interface ICarousselDao {
	
	public int addImageDao(Caroussel caroussel);
	
	public void deleteImageDao(int pIdCaroussel);
	
	public List<Caroussel> getAllCaroussel();
	
	public Caroussel getCarousselDao (int pIdCaroussel);
	
	public void updateCarousselDao (Caroussel caroussel);
}

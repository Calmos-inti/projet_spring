package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Panier;

public interface IPanierDao {
	
	
	public int addPanierDao(Panier pPanier);
	
	public void updatePanierDao(Panier pPanier);
	
	public void deletePanierDao(int pIdPanier);
	
	public Panier getPanierDao(int pIdPanier);
	
	public List<Panier> getAllPanierDao();

}

package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Panier;

public interface IPanierService {
	
	public int addPanierService(Panier pPanier);

	public void updatePanierService(Panier pPanier);

	public void deletePanierService(int pIdPanier);

	public Panier getPanierService(int pIdPanier);

	public List<Panier> getAllPanierService();

}

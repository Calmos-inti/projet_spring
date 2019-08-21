package fr.adaming.service;

import java.util.List;


import fr.adaming.model.LignePanier;

public interface ILignePanierService {
	
	public int addLignePanierService(LignePanier pLignePanier);

	public void updateLignePanierService(LignePanier pLignePanier);

	public void deleteLignePanierService(int pIdLignePanier);

	public LignePanier getLignePanierService(int pIdLignePanier);

	public List<LignePanier> getAllLignePanierService();

}

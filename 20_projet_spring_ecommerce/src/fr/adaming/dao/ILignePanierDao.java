package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.LignePanier;

public interface ILignePanierDao {
	
	public int addLignePanierDao(LignePanier pLignePanier);

	public void updateLignePanierDao(LignePanier pLignePanier);

	public void deleteLignePanierDao(int pIdLignePanier);

	public LignePanier getLignePanierDao(int pIdLignePanier);

	public List<LignePanier> getAllLignePanierDao();


}

package fr.adaming.dao;

import java.util.List;


import fr.adaming.model.Commande;

public interface ICommandeDao {
	
	
	public int addCommandeDao(Commande pCommande);

	public void updateCommandeDao(Commande pCommande);

	public void deleteCommandeDao(int pIdCommande);

	public Commande getCommandeDao(int pIdCommande);

	public List<Commande> getAllCommandeDao();


}

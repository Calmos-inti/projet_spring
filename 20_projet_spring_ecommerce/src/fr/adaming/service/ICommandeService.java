package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Commande;

public interface ICommandeService {
	
	public int addCommandeService(Commande pCommande);

	public void updateCommandeService(Commande pCommande);

	public void deleteCommandeService(int pIdCommande);

	public Commande getCommandeService(int pIdCommande);

	public List<Commande> getAllCommandeService();

}

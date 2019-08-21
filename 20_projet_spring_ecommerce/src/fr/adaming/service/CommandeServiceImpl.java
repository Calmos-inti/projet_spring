package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.dao.ICommandeDao;
import fr.adaming.model.Commande;

public class CommandeServiceImpl implements ICommandeService {
	
	
	/* _______________ Déclaration de la classe Dao ________________ */
	
	@Autowired
	ICommandeDao commandeDao;
	
	
	//setter pour injection spring
	
	public void setCommandeDao(ICommandeDao commandeDao) {
		this.commandeDao = commandeDao;
	}
	
	/* ____________________ Les méthodes ________________________ */

	

	@Override
	public int addCommandeService(Commande pCommande) {
		
		return commandeDao.addCommandeDao(pCommande);
	}

	

	@Override
	public void updateCommandeService(Commande pCommande) {
		commandeDao.updateCommandeDao(pCommande);
		
	}

	@Override
	public void deleteCommandeService(int pIdCommande) {
		commandeDao.deleteCommandeDao(pIdCommande);
		
	}

	@Override
	public Commande getCommandeService(int pIdCommande) {
		
		return commandeDao.getCommandeDao(pIdCommande);
	}

	@Override
	public List<Commande> getAllCommandeService() {
	
		return commandeDao.getAllCommandeDao();
	}

}

package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.ICommandeDao;
import fr.adaming.dao.ILignePanierDao;
import fr.adaming.model.Commande;
import fr.adaming.model.LignePanier;

@Service
public class LignePanierServiceImpl implements ILignePanierService {
	
	
	/* _______________ Déclaration de la classe Dao ________________ */
	
	@Autowired
	ILignePanierDao lignePanierDao;
	
	@Autowired
	ICommandeDao commandeDao;
	
	/* ____________________ Setters de la dao pour injection Spring ________________________ */
	
	
	public void setLignePanierDao(ILignePanierDao lignePanierDao) {
		this.lignePanierDao = lignePanierDao;
	}
	
	public void setCommandeDao(ICommandeDao commandeDao) {
		this.commandeDao = commandeDao;
	}
	
	/* ____________________ Méthodes du crude ________________________ */

	@Override
	public int addLignePanierService(LignePanier pLignePanier) {
		pLignePanier.setPrix(pLignePanier.getQuantité()*pLignePanier.getProduit().getPrix());
		return lignePanierDao.addLignePanierDao(pLignePanier);
	}

	

	@Override
	public void updateLignePanierService(LignePanier pLignePanier) {
		lignePanierDao.updateLignePanierDao(pLignePanier);
	
		
	}

	@Override
	public void deleteLignePanierService(int pIdLignePanier) {
		lignePanierDao.deleteLignePanierDao(pIdLignePanier);
		
	}

	@Override
	public LignePanier getLignePanierService(int pIdLignePanier) {
		
		return lignePanierDao.getLignePanierDao(pIdLignePanier);
	}

	@Override
	public List<LignePanier> getAllLignePanierService() {
		
		return lignePanierDao.getAllLignePanierDao();
	}
	
	@Override
	public void ajouterLignePanierDansCommandeBDD(LignePanier pLignePanier, Commande pCommande) {
		
		pLignePanier.setCommande(pCommande);
		lignePanierDao.updateLignePanierDao(pLignePanier);
		pCommande=commandeDao.getCommandeDao(pCommande.getId());
		List<LignePanier> listeLignePanier = pCommande.getListeLignePanier();
		
		Double total = 0.0;
		
		for(LignePanier lignePanier : listeLignePanier) {
			System.out.println("> Prix de la ligne:"+lignePanier.getPrix());
			total = total + lignePanier.getPrix();
		}
		
		System.out.println("tolal="+ total);
		pCommande.setTotal(total);
		commandeDao.updateCommandeDao(pCommande);
	}
}

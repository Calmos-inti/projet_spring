package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IPanierDao;
import fr.adaming.model.Panier;

@Service
public class PanierServiceImpl implements IPanierService{
	
	
	/* _______________ Déclaration de la classe Dao ________________ */
	
	@Autowired
	IPanierDao panierDao;
	
	
	/* ____________________ Setters de la dao pour injection Spring ________________________ */
	
	public void setPanierDao(IPanierDao panierDao) {
		this.panierDao = panierDao;
	}
	
	
	/* ____________________ Méthodes du crude ________________________ */
	

	@Override
	public int addPanierService(Panier pPanier) {
		
		return panierDao.addPanierDao(pPanier);
	}

	

	@Override
	public void updatePanierService(Panier pPanier) {
		panierDao.updatePanierDao(pPanier);
		
	}

	@Override
	public void deletePanierService(int pIdPanier) {
		panierDao.deletePanierDao(pIdPanier);
		
	}

	@Override
	public Panier getPanierService(int pIdPanier) {
		
		return panierDao.getPanierDao(pIdPanier);
	}

	@Override
	public List<Panier> getAllPanierService() {
		
		return panierDao.getAllPanierDao();
	}

}

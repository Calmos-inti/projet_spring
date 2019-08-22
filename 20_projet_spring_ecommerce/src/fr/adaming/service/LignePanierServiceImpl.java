package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.ILignePanierDao;
import fr.adaming.model.LignePanier;

@Service
public class LignePanierServiceImpl implements ILignePanierService {
	
	
	/* _______________ Déclaration de la classe Dao ________________ */
	
	@Autowired
	ILignePanierDao lignePanierDao;
	
	
	/* ____________________ Setters de la dao pour injection Spring ________________________ */
	
	
	public void setLignePanierDao(ILignePanierDao lignePanierDao) {
		this.lignePanierDao = lignePanierDao;
	}
	
	
	/* ____________________ Méthodes du crude ________________________ */
	

	@Override
	public int addLignePanierService(LignePanier pLignePanier) {
	
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

}

package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Produit;

@Service
public class ProduitServiceImpl implements IProduitService{

	/* _______________ Déclaration de la classe Dao ________________ */
	@Autowired
	IProduitDao produitDao;
	
	//setter pour injection spring

	public void setProduitDao(IProduitDao produitDao) {
		this.produitDao = produitDao;
	}

	
	/* _______________ Déclaration de la classe Dao ________________ */
	
	@Override
	public int addProduit(Produit pProduit) {
		
		return produitDao.addProduit(pProduit);
	}

	@Override
	public void updateProduit(Produit pProduit) {
		produitDao.updateProduit(pProduit);
	}

	@Override
	public void deleteProduit(int pIdProduit) {
		produitDao.deleteProduit(pIdProduit);
	}

	@Override
	public Produit getProduit(int pIdProduit) {
		return produitDao.getProduit(pIdProduit);
	}

	@Override
	public List<Produit> getAllProduit() {
		return produitDao.getAllProduit();
	}

}

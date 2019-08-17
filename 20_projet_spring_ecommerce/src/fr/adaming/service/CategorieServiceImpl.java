package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Categorie;

@Service
public class CategorieServiceImpl implements ICategorieService {

	/* _______________ Déclaration de la classe Dao ________________ */
	
	@Autowired
	ICategorieDao categorieDao;
	
	//setter pour injection spring
	
	public void setCategorieDao(ICategorieDao categorieDao) {
		this.categorieDao = categorieDao;
	}
	
	
	/* ____________________ Les méthodes ________________________ */
	@Override
	public int addCategorie(Categorie pCategorie) {
		return categorieDao.addCategorie(pCategorie);
	}

	@Override
	public void updateCategorie(Categorie pCatogorie) {
		categorieDao.updateCategorie(pCatogorie);
	}

	@Override
	public void deleteCategorie(int pIdCategorie) {
		categorieDao.deleteCategorie(pIdCategorie);
	}

	@Override
	public Categorie getCategorie(int pIdCategorie) {
		return categorieDao.getCategorie(pIdCategorie);
	}

	@Override
	public List<Categorie> getAllCategories() {
		return categorieDao.getAllCategories();
	}

}

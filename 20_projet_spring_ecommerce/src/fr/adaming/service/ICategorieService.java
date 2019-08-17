package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;

public interface ICategorieService {

	public int addCategorie(Categorie pCategorie);
	public void updateCategorie (Categorie pCatogorie);
	public void deleteCategorie (int pIdCategorie);
	public Categorie getCategorie (int pIdCategorie);
	public List<Categorie> getAllCategories();

}

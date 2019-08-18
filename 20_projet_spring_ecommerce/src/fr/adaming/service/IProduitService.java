package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Produit;

public interface IProduitService {

	public int addProduit(Produit pProduit);
	public void updateProduit (Produit pProduit);;
	public void deleteProduit (int pIdProduit);;
	public Produit getProduit(int pIdProduit);
	public List<Produit> getAllProduit();
	
	/*--------------------------------------------------------*/
	
	//public List<Produit> getProduitsByMotCle();
	//public List<Produit> getProduitsByCategorie();
	//public List<Produit> getProduitsSelectionnes();
	
	
}

package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Produit;

public interface IProduitDao {
	
	public int addProduit(Produit pProduit);
	public void updateProduit (Produit pProduit);;
	public void deleteProduit (Produit pProduit);;
	public Produit getProduit(int pIdProduit);
	public List<Produit> getAllProduit();
	
	/*--------------------------------------------------------*/
	
	//public List<Produit> getProduitsByMotCle();
	//public List<Produit> getProduitsByCategorie();
	//public List<Produit> getProduitsSelectionnes();
	
	

}
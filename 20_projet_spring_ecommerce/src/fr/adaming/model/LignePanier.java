package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name="lignePanier")
@Table(name="ligne_paniers")
public class LignePanier {
	
	/* _____________________ Attributs ________________________ */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="quantite")
	private int quantité;
	
	private double prix;
	
	//* _____________________ Association (UML) ________________________ */
	

	// a faire : ManyToMany
	@OneToMany(fetch = FetchType.EAGER, mappedBy ="lignePanier")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Produit> listeProduit;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="panier_id",nullable=false)
	private Panier panier;

	
	
	/* _____________________ Constructeurs ________________________ */
	
	public LignePanier() {
		super();
	}



	public LignePanier(int id, int quantité, List<Produit> listeProduit) {
		super();
		this.id = id;
		this.quantité = quantité;
		this.listeProduit = listeProduit;
	}


	public LignePanier(int quantité, List<Produit> listeProduit) {
		super();
		this.quantité = quantité;
		this.listeProduit = listeProduit;
	}
	
	
	
	

	public LignePanier(int quantité, double prix, List<Produit> listeProduit, Panier panier) {
		super();
		this.quantité = quantité;
		this.prix = prix;
		this.listeProduit = listeProduit;
		this.panier = panier;
	}


	
	

	public LignePanier(int quantité, double prix, List<Produit> listeProduit) {
		super();
		this.quantité = quantité;
		this.prix = prix;
		this.listeProduit = listeProduit;
	}



	/* _____________________ Getters et Setters ________________________ */

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getQuantité() {
		return quantité;
	}



	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}



	public List<Produit> getListeProduit() {
		return listeProduit;
	}



	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}



	public double getPrix() {
		return prix;
	}



	public void setPrix(double prix) {
		this.prix = prix;
	}



	public Panier getPanier() {
		return panier;
	}



	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	
	
	
	
	
	
	
	
	
	
}

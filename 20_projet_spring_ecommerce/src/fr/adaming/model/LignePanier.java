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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="ligne_panier")
@Table(name="ligne_paniers")
public class LignePanier {
	
	/* _____________________ Attributs ________________________ */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="quantite")
	private int quantit�;
	
	//* _____________________ Association (UML) ________________________ */
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy ="ligne_panier")
	private List<Produit> listeProduit;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="panier_id",nullable=false)
	private Panier panier;

	
	
	/* _____________________ Constructeurs ________________________ */
	
	public LignePanier() {
		super();
	}



	public LignePanier(int id, int quantit�, List<Produit> listeProduit) {
		super();
		this.id = id;
		this.quantit� = quantit�;
		this.listeProduit = listeProduit;
	}


	public LignePanier(int quantit�, List<Produit> listeProduit) {
		super();
		this.quantit� = quantit�;
		this.listeProduit = listeProduit;
	}

	/* _____________________ Getters et Setters ________________________ */

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getQuantit�() {
		return quantit�;
	}



	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}



	public List<Produit> getListeProduit() {
		return listeProduit;
	}



	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}



	
	
	
	
	
	
	
	
	
	
}

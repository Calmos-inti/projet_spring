package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "lignePanier")
@Table(name = "ligne_paniers")
public class LignePanier {

	/* _____________________ Attributs ________________________ */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lignePanier")
	private int id;

	@Column(name = "quantite")
	private int quantite;

	@Column(name = "prix")
	private double prix;

	// * _____________________ Association (UML) ________________________ */


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "produit_id", nullable = false)
	private Produit produit;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "panier_id", nullable = false)
	private Panier panier;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "commande_id")
	private Commande commande;

	/* _____________________ Constructeurs ________________________ */

	public LignePanier() {
		super();
	}

	public LignePanier(int id, int quantite, Produit produit) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.produit = produit;
	}

	public LignePanier(int quantite, Produit produit) {
		super();
		this.quantite = quantite;
		this.produit = produit;
	}

	public LignePanier(int quantite, Produit produit, Panier panier) {
		super();
		this.quantite = quantite;
		this.produit = produit;
		this.panier = panier;
	}

	/* _____________________ Getters et Setters ________________________ */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
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

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}

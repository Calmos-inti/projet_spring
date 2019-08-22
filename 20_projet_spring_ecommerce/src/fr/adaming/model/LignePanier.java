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

@Entity(name = "lignePanier")
@Table(name = "ligne_paniers")
public class LignePanier {

	/* _____________________ Attributs ________________________ */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lignePanier")
	private int id;

	@Column(name = "quantite")
	private int quantité;

	@Column(name = "prix")
	private double prix;

	// * _____________________ Association (UML) ________________________ */

	// a faire : ManyToMany

	@OneToMany(fetch = FetchType.EAGER, mappedBy ="lignePanier")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Produit> listeProduit;
	
	// @Fetch(value = FetchMode.SUBSELECT)
	// @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// @JoinTable(name = "lignePanier_produit", joinColumns = {
	// @JoinColumn(name = "id_lignePanier", nullable = false, updatable = false) },
	// inverseJoinColumns = {
	// @JoinColumn(name = "id_produit", nullable = false, updatable = false) })
	// private List<Produit> listeProduit;
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

	public LignePanier(int id, int quantité, Produit produit) {
		super();
		this.id = id;
		this.quantité = quantité;
		this.produit = produit;
	}

	public LignePanier(int quantité, Produit produit) {
		super();
		this.quantité = quantité;
		this.produit = produit;
	}

	public LignePanier(int quantité, Produit produit, Panier panier) {
		super();
		this.quantité = quantité;
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

	public int getQuantité() {
		return quantité;
	}

	public void setQuantité(int quantité) {
		this.quantité = quantité;
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

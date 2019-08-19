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



@Entity(name = "produit")
@Table(name = "produits")
public class Produit {

	/* _____________________ Attributs ________________________ */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produit")
	private int idProduit;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "prix")
	private double prix;
	
	@Column(name = "quantite")
	private int quantite;
	
	@Column(name = "selection")
	private boolean selection;
	
	@Column(name = "photo")
	private String photo;

	// transformation de l'association UML en Java
//	@ManyToOne
//	@JoinColumn(name = "categorie_id", referencedColumnName = "id_categorie")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categorie_id", nullable = false) 
	private Categorie categorie;

	/* _____________________ Constructeurs ________________________ */

	// constructeur vide

	public Produit() {
		super();
	}

	// constructeur chargé sans ID
	public Produit(String designation, String description, double prix, int quantite, boolean selection, String photo) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selection = selection;
		this.photo = photo;
	}

	// constructeur chargé avec ID
	public Produit(int idProduit, String designation, String description, double prix, int quantite, boolean selection,
			String photo) {
		super();
		this.idProduit = idProduit;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selection = selection;
		this.photo = photo;
	}

	/* _____________________ Getters & Setters ________________________ */

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public boolean isSelection() {
		return selection;
	}

	public void setSelection(boolean selection) {
		this.selection = selection;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}

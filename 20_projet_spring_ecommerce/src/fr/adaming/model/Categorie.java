package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "categorie")
@Table(name = "categories")
public class Categorie {

	/* _____________________ Attributs ________________________ */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categorie")
	private int idCategorie;
	
	@Column(name = "nom")
	private String nomCategorie;
	
	@Column(name = "photo")
	private byte[] photo;
	
	@Column(name = "description")
	private String description;

	// transformation de l'association ULM en Java
	//@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "categorie")
	private List<Produit> listeProduits;

	/* _____________________ Constructeurs ________________________ */

	// constructeur vide
	public Categorie() {
		super();
	}

	// constructeur chargé sans l'ID

	public Categorie(String nomCategorie, byte[] photo, String description, List<Produit> listeProduits) {
		super();
		this.nomCategorie = nomCategorie;
		this.photo = photo;
		this.description = description;
		this.listeProduits = listeProduits;

	}
	
	// constructeur chargé sans l'ID et la liste

		public Categorie(String nomCategorie, byte[] photo, String description) {
			super();
			this.nomCategorie = nomCategorie;
			this.photo = photo;
			this.description = description;
		}


	// constructeur chargé avec tout

	public Categorie(int idCategorie, String nomCategorie, byte[] photo, String description,
			List<Produit> listeProduits) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.photo = photo;
		this.description = description;
		this.listeProduits = listeProduits;
	}

	/* _____________________ Getters & Setters ________________________ */
	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

}

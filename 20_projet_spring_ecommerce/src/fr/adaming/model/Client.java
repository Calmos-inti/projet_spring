package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity (name="client")
@DiscriminatorValue("1")
public class Client extends User {

	/* _____________________ Attributs ________________________ */

	@Column(name = "nom")
	private String nom;

	@Column(name = "adresse")
	private String adresse;

	@Column(name = "telephone")
	private String telephone;
	
	
	
	/* _____________________ Association (UML) ________________________ */
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="client")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Commande> listeCommandes;
	
	@OneToOne(mappedBy="client", cascade=CascadeType.ALL)
	private Panier panier;

	/* _____________________ Constructeurs ________________________ */

	// Constructeur vide
	public Client() {
		super();
	}

	// Constructeur chargé sans l'id et la liste des roles
	public Client(String mail, String password, Boolean enabled, String nom, String adresse, String telephone) {
		super(mail, password, enabled);
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
	}

	/* _____________________ Getters et Setters ________________________ */

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Commande> getListeCommandes() {
		return listeCommandes;
	}

	public void setListeCommandes(List<Commande> listeCommandes) {
		this.listeCommandes = listeCommandes;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	
	/* ________________ Redéfinition de la méthode toString _________________ */
	
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + ", listeCommandes="
				+ listeCommandes + ", panier=" + panier + "]";
	}


	
	
	

	
}

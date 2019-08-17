package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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

	/* _____________________ Constructeurs ________________________ */

	// Constructeur vide
	public Client() {
		super();
	}

	// Constructeur chargé sans l'id
	public Client(String mail, String password, List<Role> listeRoles, String nom, String adresse, String telephone) {
		super(mail, password, listeRoles);
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
	}

	// Constructeur chargé sans l'id
	public Client(String mail, String password, String nom, String adresse, String telephone) {
		super(mail, password);
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
	}

	// Constructeur chargé avec tout
	public Client(int id, String mail, String password, List<Role> listeRoles, String nom, String adresse,
			String telephone) {
		super(id, mail, password, listeRoles);
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

	/* ________________ Redéfinition de la méthode toString _________________ */
	
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + "]";
	}

}

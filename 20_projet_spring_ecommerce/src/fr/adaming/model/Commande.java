package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="commande")
@Table(name="commandes")
public class Commande {
	
	/* _____________________ Attributs ________________________ */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_commande")
	private int id;
	
	@Column(name="validation_commande")
	private boolean valider;
	
	
	/* _____________________ Association (UML) ________________________ */
	
	
	@OneToOne
	private Panier panier;
	
	@ManyToOne
	private Client client;

	
	
	/* _____________________ Constructeurs ________________________ */
	
	public Commande() {
		super();
	}



	public Commande(Panier panier, Client client, boolean valider) {
		super();
		this.valider = valider;
		this.panier = panier;
		this.client = client;
	}



	public Commande(int id, boolean valider, Panier panier, Client client) {
		super();
		this.id = id;
		this.valider = valider;
		this.panier = panier;
		this.client = client;
	}


	/* _____________________ Getters et Setters ________________________ */

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public boolean isValider() {
		return valider;
	}



	public void setValider(boolean valider) {
		this.valider = valider;
	}



	public Panier getPanier() {
		return panier;
	}



	public void setPanier(Panier panier) {
		this.panier = panier;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
	
	
	
	
	
	
	
}

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

@Entity(name = "commande")
@Table(name = "commandes")
public class Commande {

	/* _____________________ Attributs ________________________ */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_commande")
	private int id;
	
	@Column (name ="total")
	private double total;

	@Column(name = "validation_commande")
	private boolean valider;

	/* _____________________ Association (UML) ________________________ */

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "commande")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<LignePanier> listeLignePanier;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id", nullable = false) 
	private Client client;

	/* _____________________ Constructeurs ________________________ */

	public Commande() {
		super();
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<LignePanier> getListeLignePanier() {
		return listeLignePanier;
	}

	public void setListeLignePanier(List<LignePanier> listeLignePanier) {
		this.listeLignePanier = listeLignePanier;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}

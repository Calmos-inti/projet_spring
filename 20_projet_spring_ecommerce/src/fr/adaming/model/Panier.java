package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity (name="panier")
@Table(name="paniers")
public class Panier {
	
	/* _____________________ Attributs ________________________ */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_panier")
	private int id;
	
	@Column (name ="total")
	private int total;
	
	
	
	//* _____________________ Association (UML) ________________________ */
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="panier")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<LignePanier> listeLignePanier;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;

	/* _____________________ Constructeurs ________________________ */
	
	
	public Panier() {
		super();
	}




	public Panier(int total, List<LignePanier> listeLignePanier, Client idClient) {
		super();
		this.total = total;
		this.listeLignePanier = listeLignePanier;
		this.client = idClient;
	}




	public Panier(int id, int total, List<LignePanier> listeLignePanier, Client idClient) {
		super();
		this.id = id;
		this.total = total;
		this.listeLignePanier = listeLignePanier;
		this.client = idClient;
	}


	
	

	public Panier(int total, Client idClient) {
		super();
		this.total = total;
		this.client = idClient;
	}




	/* _____________________ Getters et Setters ________________________ */

	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getTotal() {
		return total;
	}




	public void setTotal(int total) {
		this.total = total;
	}




	public List<LignePanier> getListeLignePanier() {
		return listeLignePanier;
	}




	public void setListeLignePanier(List<LignePanier> listeLignePanier) {
		this.listeLignePanier = listeLignePanier;
	}




	public Client getClient() {
		return client;
	}




	public void setClient(Client client) {
		this.client = client;
	}


	

	

















}

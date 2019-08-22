package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name="user")
@Table(name="users")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", 
					 discriminatorType=DiscriminatorType.INTEGER)	
@DiscriminatorValue("2")
public class User {
	
	/*_____________________ Attributs ________________________*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private int id;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private boolean enabled;
	
	/*_____________________ Association (UML) ________________________*/
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Role> listeRoles;
	

	/*_____________________ Constructeurs ________________________*/
	
	// Constructeur vide
	public User() {
		super();
	}
	
	// Constructeur chargé sans l'id et listeRoles
	
	public User(String mail, String password, boolean enabled) {
		super();
		this.mail = mail;
		this.password = password;
		this.enabled = enabled;
	}

	// Constructeur chargé avec tout
	public User(int id, String mail, String password, boolean enabled, List<Role> listeRoles) {
		super();
		this.id = id;
		this.mail = mail;
		this.password = password;
		this.enabled = enabled;
		this.listeRoles = listeRoles;
	}
	
	/*_____________________ Getters et Setters ________________________*/
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getListeRoles() {
		return listeRoles;
	}

	public void setListeRoles(List<Role> listeRoles) {
		this.listeRoles = listeRoles;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/* ________________ Redéfinition de la méthode toString _________________ */
	
	@Override
	public String toString() {
		return "User [id=" + id + ", mail=" + mail + ", password=" + password + ", listeRoles=" + listeRoles + "]";
	}
	
}

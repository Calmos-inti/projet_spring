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

@Entity(name="role")
@Table(name = "user_role")
public class Role {

	/* _____________________ Attributs ________________________ */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "role")
	private String roleName;

	/* _____________________ Association (UML) ________________________ */

	@ManyToOne(fetch = FetchType.EAGER) //lasy
	@JoinColumn(name = "user_id", nullable = false) // , referencedColumnName = "id_user"insertable = false, updatable = false
	private User user;

	/* _____________________ Constructeurs ________________________ */

	public Role() {
		super();
	}

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	
	/* _____________________ Getters et Setters ________________________ */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/* ________________ Redéfinition de la méthode toString _________________ */
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName  + "]";
	}
}

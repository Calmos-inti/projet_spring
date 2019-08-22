package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "caroussel")
@Table(name = "imagesCaroussel")
public class Caroussel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_caroussel")
	private int idCaroussel;
	
	@Column(name = "photo", columnDefinition="longblob")
	private byte[] photo;
	
	@Column(name = "photo2", columnDefinition="longblob")
	private byte[] photo2;
	
	@Column(name = "photo3", columnDefinition="longblob")
	private byte[] photo3;

	public Caroussel() {
		super();
	}

	public Caroussel(byte[] photo, byte[] photo2, byte[] photo3) {
		super();
		this.photo = photo;
		this.photo2 = photo2;
		this.photo3 = photo3;
	}

	public Caroussel(int idCaroussel, byte[] photo, byte[] photo2, byte[] photo3) {
		super();
		this.idCaroussel = idCaroussel;
		this.photo = photo;
		this.photo2 = photo2;
		this.photo3 = photo3;
	}

	public int getIdCaroussel() {
		return idCaroussel;
	}

	public void setIdCaroussel(int idCaroussel) {
		this.idCaroussel = idCaroussel;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public byte[] getPhoto2() {
		return photo2;
	}

	public void setPhoto2(byte[] photo2) {
		this.photo2 = photo2;
	}

	public byte[] getPhoto3() {
		return photo3;
	}

	public void setPhoto3(byte[] photo3) {
		this.photo3 = photo3;
	}
	
	

}

package tn.essat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Produit {
@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
private Integer id;
private String titre;
private float prix;
@Lob
private byte[] image;
public Produit(Integer id, String titre, float prix, byte[] image) {
	super();
	this.id = id;
	this.titre = titre;
	this.prix = prix;
	this.image = image;
}
public Produit(String titre, float prix, byte[] image) {
	super();
	this.titre = titre;
	this.prix = prix;
	this.image = image;
}
public Produit() {
	super();
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public float getPrix() {
	return prix;
}
public void setPrix(float prix) {
	this.prix = prix;
}
public byte[] getImage() {
	return image;
}
public void setImage(byte[] image) {
	this.image = image;
}

	}



package tn.essat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titre;
	private String autuer;
	private String imagename ;
	public Livre() {
		super();
	}
	public Livre(Integer id, String titre, String autuer,String imagename) {
		
		super();
		this.id = id;
		this.titre = titre;
		this.autuer = autuer;
		this.imagename=imagename;
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
	public String getAutuer() {
		return autuer;
	}
	public void setAutuer(String autuer) {
		this.autuer = autuer;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	
	
}

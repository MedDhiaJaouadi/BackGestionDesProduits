package tn.essat.respone;

import java.util.List;

import tn.essat.model.Role;

public class Authresponse {
	private String nom;
	private String username;
	private String Token;
	private List<Role> role;
	public Authresponse() {
		super();
	}
	public Authresponse(String nom, String username, String token,List<Role> role) {
		super();
		this.nom = nom;
		this.username = username;
		this.Token = token;
		this.role=role;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		this.Token = token;
	}
	public List<Role> getRole() {
		return role;
	}
	public void setRole(List<Role> role) {
		this.role = role;
	}
	

}

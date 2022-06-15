package tn.essat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.essat.model.Livre;
@Repository
public interface ILivre extends JpaRepository<Livre, Integer> {
	public List<Livre> findByAutuer(String autuer);
	
}

package tn.essat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.essat.model.Produit;
@Repository
public interface IGestionDao extends JpaRepository<Produit, Integer> {
	@Query("select m from Produit m where m.titre like %:x%")
	public List<Produit> getAllProduitbytitre(@Param("x")String titre);

}

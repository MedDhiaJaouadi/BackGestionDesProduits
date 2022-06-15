package tn.essat.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import tn.essat.dao.IGestionDao;
import tn.essat.model.Produit;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/rest")
public class ProdRest{
	
@Autowired
IGestionDao dao;

@GetMapping("/produits")
public List<Produit>fnct1(){
	return dao.findAll();
	
}
@GetMapping("/produit/{id}")
public Optional<Produit> fnct2(@PathVariable("id")int id) {
	return dao.findById(id);
	
}
@DeleteMapping("/delete/{id}")
public void fnct3(@PathVariable("id") Integer id) {
     dao.deleteById(id);
	
}
 @PostMapping("/add")
 public void fnct4(@RequestParam("file") MultipartFile image,@RequestParam("prod") String pdt) {
	 try {
	 if(!image.isEmpty()) {
		 ObjectMapper obj =new  ObjectMapper();
		 Produit p=obj.readValue(pdt, Produit.class);
		 byte[] file=image.getBytes();
		 dao.save(new Produit(p.getTitre(), p.getPrix(), file));
	 }}
	 catch (Exception e) {
		// TODO: handle exception
	}
 }
 @GetMapping("/ProduitBytitre/{titre}")
 public List<Produit> f10(@PathVariable("titre") String titre) {
 return dao.getAllProduitbytitre(titre);


 }

 @PostMapping("/update")
 public Produit f7(@RequestBody Produit produit) {
	 return dao.save(produit);
 }


}

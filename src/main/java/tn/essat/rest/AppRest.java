package tn.essat.rest;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tn.essat.dao.ILivre;
import tn.essat.dao.IUser;
import tn.essat.model.Livre;
import tn.essat.model.User;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/rest")
public class AppRest {

	@Autowired
	IUser daou;
	@Autowired
	ILivre daom;
	@Autowired
	ServletContext context;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/all")
	public List<Livre> get1() {
		return daom.findAll();
	}

	@GetMapping("/allUser")
	public List<User> get2() {
		return daou.findAll();
	}

	@GetMapping("/test")
	public String get3() {
		return "hay hay habatni";
	}

	@RequestMapping(value = "/saveLivre")
	public Livre get4(@RequestParam("file") MultipartFile file,@RequestParam("Livre") String lv) throws JsonParseException , JsonMappingException , Exception{
		Livre LL = new ObjectMapper().readValue(lv, Livre.class);
		boolean isExit = new File(context.getRealPath("/Images/")).exists();
		System.out.println(lv);
        if (!isExit)
        {
        	new File (context.getRealPath("/Images/")).mkdir();
        	System.out.println("mk dir.............");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
        try
        {
        	System.out.println("Image");
        	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
        	 
        }catch(Exception e) {
        	e.printStackTrace();
        }
       LL.setImagename(newFileName);
		return daom.save(LL);
	}
	
	 @GetMapping ("/getAll")
	 public String getAll()
	 {
		 char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		 StringBuilder sb = new StringBuilder();
		 Random random = new Random();
		 // Exemple d'une chaine aléatoire de 20 caractères
		 for (int i = 0; i < 20; i++) {
		     char c = chars[random.nextInt(chars.length)];
		     sb.append(c);
		 }
		 String output = sb.toString();
		 return output;
	 }
	 @GetMapping("/Imgarticles/{id}")
	 public byte[] getPhoto(@PathVariable("id") Integer id) throws Exception{
		 
		 Livre Article   = daom.findById(id).get();
		 return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+Article.getImagename()));
	 }
	@PostMapping("/save")
	public User get3(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return daou.save(user);
	}
	@GetMapping("/Userbyname/{name}")
	public User get3(@PathVariable("name") String name) {
		return daou.findByUsername(name);
	}

}

package tn.essat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.essat.model.User;
@Repository
public interface IUser extends JpaRepository<User, Integer>{
	public List<User> findByUsernameAndPassword(String username,String Password);
	
	public User findByUsername(String username);
}

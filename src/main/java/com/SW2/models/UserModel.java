package com.SW2.models;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SW2.enteties.Userentinty;
import com.SW2.service.UserDetailsServiceImpl;

@Service
@Transactional
public class UserModel {
	
	@Autowired
	private UserDetailsServiceImpl userservice;
	
	
	public UserModel(UserDetailsServiceImpl S) {
		this.userservice = S;
	}
	public UserModel() {}
	
	
	public List<Userentinty> listUsers(){
		return userservice.listUsers();
	}
	public void addUser(Userentinty user){
		userservice.saveUser(user, "USER");
	}
	public void addAdmin(Userentinty user){
		userservice.saveUser(user, "ADMIN");
	}
	public void addSeller(Userentinty user){
		userservice.saveUser(user, "SELLER");
	}
	public Userentinty findByUsername(String username) {
		return userservice.findByUsername(username);
	}
}

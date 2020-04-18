package com.SW2.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SW2.enteties.Userentinty;
import com.SW2.models.UserModel;
import com.SW2.service.UserDetailsServiceImpl;

@RestController
public class UserController {
	@Autowired
	private UserDetailsServiceImpl userservice;
	@Autowired
	private UserModel usermodel=new UserModel(userservice);
	
	@RequestMapping("/all")
	public List<Userentinty> ListUsers(){
		return usermodel.listUsers();
	}
	@RequestMapping("/addUser")
	public String Register(@RequestParam String name,@RequestParam String username,@RequestParam String password) {
		Userentinty test=usermodel.findByUsername(username);
		if(test!=null) {
			return"Username already exists";
		}
		else {
		Userentinty user =new Userentinty(name, username, password);
		usermodel.addUser(user);
		return "regiestered the user succesfully";
		}
	}
	@RequestMapping("/addAdmin")
	public String Registeradmin(@RequestParam String name,@RequestParam String username,@RequestParam String password) {
		Userentinty test=usermodel.findByUsername(username);
		if(test!=null) {
			return"Username already exists";
		}
		else {
			Userentinty user =new Userentinty(name, username, password);
			usermodel.addAdmin(user);
			return "regiestered the admin succesfully";
		}
		
	}
	@RequestMapping("/addSeller")
	public String RegisterSeller(@RequestParam String name,@RequestParam String username,@RequestParam String password) {
		Userentinty test=usermodel.findByUsername(username);
		if(test!=null) {
			return"Username already exists";
		}
		else {
			Userentinty user =new Userentinty(name, username, password);
			usermodel.addSeller(user);
			return "regiestered the seller succesfully";
		}
	}
	@RequestMapping("/test")
	public String test() {
		return "Hello Welcome User";
	}
}

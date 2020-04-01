package com.SW2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SW2.enteties.Userentinty;
import com.SW2.models.DatabaseSeeder;
import com.SW2.models.Repository;
import com.SW2.models.UserModel;

@RestController
public class UserController {
	@Autowired
	private Repository repository;
	private DatabaseSeeder seeder=new DatabaseSeeder(repository);
	@RequestMapping("/all")
	public List<Userentinty> ListUsers(){
		UserModel usermodel = new UserModel(repository);
		return usermodel.listUsers();
	}
	
	@RequestMapping("/add")
	public void Register(@RequestParam String name,@RequestParam String userName,@RequestParam String password) {
		UserModel usermodel = new UserModel(repository);
		Userentinty user =new Userentinty(name, userName, password);
		usermodel.addUser(user);
	}
}

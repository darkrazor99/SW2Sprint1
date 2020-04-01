package com.SW2.models;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SW2.enteties.Userentinty;

@Service
@Transactional
public class UserModel {

	private Repository repository;
	
	
	@Autowired
	public UserModel(Repository repository) {
		this.repository = repository;
	}
	public UserModel() {}
	
	
	public List<Userentinty> listUsers(){
		return repository.findAll();
	}
	public void addUser(Userentinty user) {
		repository.save(user);
	}
}

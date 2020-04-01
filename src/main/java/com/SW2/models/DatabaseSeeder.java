package com.SW2.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.SW2.enteties.Userentinty;


@Component
//this class initilizes the data base with some data
public class DatabaseSeeder implements CommandLineRunner {
	private Repository repository;
	
	
	@Autowired
	public DatabaseSeeder(Repository repository) {
		this.repository = repository;
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		List<Userentinty> users = new ArrayList<>();
		users.add(new Userentinty("ahmed","ahmed2020","1234"));
		users.add(new Userentinty("soha","soha2020","1334"));
		users.add(new Userentinty("tarek","tarek2020","4444"));
		
		repository.saveAll(users);
	
	}
}

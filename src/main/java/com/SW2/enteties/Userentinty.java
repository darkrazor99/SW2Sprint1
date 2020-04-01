package com.SW2.enteties;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import net.bytebuddy.asm.Advice.This;

@Entity
public class Userentinty {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	
	private String name;
	private String userName;
	private String password;
	
	public Userentinty() {}
	public Userentinty(String name, String userName , String password) {
		this.name=name;
		this.userName=userName;
		this.password=password;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getUserName() {
		return userName;
	}
	public long getId() {
		return id;
	}
	
}
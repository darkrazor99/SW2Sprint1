package com.SW2.enteties;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Set;

@Entity
@Table(name = "user")
public class Userentinty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private String name;
	private String username;
	private String password;
	@ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set <RoleEntity> roles;
	
	public Userentinty() {}
	public Userentinty(String name, String userName , String password) {
		this.name=name;
		this.username=userName;
		this.password=password;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getUserName() {
		return username;
	}
	public long getId() {
		return id;
	}
	@JsonBackReference
	public Set < RoleEntity > getRoles() {
        return roles;
    }
	public void setRoles(Set <RoleEntity> roles) {
		this.roles=roles;
	}
	public void setId(Long id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
    	this.name=name;
    }
}
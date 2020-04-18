package com.SW2.enteties;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Set;

@Entity
@Table(name = "role")
public class RoleEntity {
	private Long id;
    private String name;
    private Set < Userentinty > users;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    @JsonManagedReference
    public Set < Userentinty > getUsers() {
        return users;
    }

    public void setUsers(Set < Userentinty > users) {
        this.users = users;
    }
}

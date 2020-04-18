package com.SW2.models;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SW2.enteties.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	RoleEntity findByName(String name);
}

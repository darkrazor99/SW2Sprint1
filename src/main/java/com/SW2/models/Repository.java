package com.SW2.models;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SW2.enteties.Userentinty;


@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Userentinty,Long>{
}


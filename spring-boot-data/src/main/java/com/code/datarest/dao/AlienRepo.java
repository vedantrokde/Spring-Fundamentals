package com.code.datarest.dao;

import com.code.datarest.modal.Alien;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "aliens", path = "alien")
public interface AlienRepo extends JpaRepository<Alien, Integer> {
    
}

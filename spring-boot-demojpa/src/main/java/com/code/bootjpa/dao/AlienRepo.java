package com.code.bootjpa.dao;

import java.util.List;

import com.code.bootjpa.modal.Alien;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.CrudRepository;   //jpareop is extended from crud

public interface AlienRepo extends JpaRepository<Alien, Integer> {
    List<Alien> findByTech(String tech);
    List<Alien> findByIdGreaterThan(int id);

    @Query("from Alien where tech=?1 order by name")
    List<Alien> findByTechSorted(String Tech);
}
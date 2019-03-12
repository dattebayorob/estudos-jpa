package com.dtb.estudosjpa.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtb.estudosjpa.model.entities.Filho;

public interface FilhoRepository extends JpaRepository<Filho, Long>{
}

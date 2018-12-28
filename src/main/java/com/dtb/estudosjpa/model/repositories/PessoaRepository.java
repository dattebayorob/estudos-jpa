package com.dtb.estudosjpa.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtb.estudosjpa.model.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}

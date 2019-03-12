package com.dtb.estudosjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtb.estudosjpa.model.entities.Filho;
import com.dtb.estudosjpa.model.repositories.FilhoRepository;

@Service
public class FilhoService {
	@Autowired
	private FilhoRepository repository;
	
	public Filho save(Filho filho) {
		return repository.save(filho);
	}
	
	public List<Filho> findAll(){
		return repository.findAll();
	}
	
	public Optional<Filho> findById(Long id){
		return repository.findById(id);
	}
}

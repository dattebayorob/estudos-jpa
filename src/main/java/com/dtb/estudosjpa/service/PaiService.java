package com.dtb.estudosjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dtb.estudosjpa.model.entities.Pai;
import com.dtb.estudosjpa.model.repositories.PaiRepository;

@Service
public class PaiService {
	@Autowired
	private PaiRepository repository;

	public Pai save(Pai pai) {
		return repository.save(pai);
	}

	@Transactional(readOnly = true)
	public List<Pai> findAll() {
		return repository.findAll();
	}

	public Optional<Pai> findById(Long id) {
		return repository.findById(id);
	}
}

package com.dtb.estudosjpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtb.estudosjpa.model.dtos.PaiComFilhosDto;
import com.dtb.estudosjpa.model.dtos.PaiDto;
import com.dtb.estudosjpa.model.entities.Pai;
import com.dtb.estudosjpa.service.PaiService;

@RestController
@RequestMapping("/pai")
public class PaiController {
	@Autowired
	private PaiService service;
	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<List<PaiDto>> findAll() {
		List<PaiDto> dtos = new ArrayList<>();
		service.findAll().forEach(pai -> dtos.add(mapper.map(pai, PaiDto.class)));
		return ResponseEntity.ok(dtos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PaiComFilhosDto> findById(@PathVariable("id") Long id) {
		Optional<Pai> pai = service.findById(id);
		if (pai.isPresent())
			return ResponseEntity.ok(mapper.map(pai.get(), PaiComFilhosDto.class));
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<PaiDto> save(@RequestBody PaiDto dto) {
		Pai pai = service.save(mapper.map(dto, Pai.class));
		return new ResponseEntity<PaiDto>(mapper.map(pai, PaiDto.class), HttpStatus.CREATED);
	}
}

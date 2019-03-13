package com.dtb.estudosjpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtb.estudosjpa.model.dtos.FilhoDto;
import com.dtb.estudosjpa.model.entities.Filho;
import com.dtb.estudosjpa.service.FilhoService;

@RestController
@RequestMapping("/filho")
public class FilhoController {
	@Autowired
	private FilhoService service;
	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<List<FilhoDto>> findAll() {
		List<FilhoDto> dtos = new ArrayList<>();
		service.findAll().forEach(f -> dtos.add(mapper.map(f, FilhoDto.class)));
		return ResponseEntity.ok(dtos);
	}

	@PostMapping
	public ResponseEntity<FilhoDto> save(@RequestBody FilhoDto dto) {
		Filho filho = mapper.map(dto, Filho.class);
		service.save(filho);
		return new ResponseEntity<FilhoDto>(mapper.map(filho, FilhoDto.class), HttpStatus.CREATED);
	}
}

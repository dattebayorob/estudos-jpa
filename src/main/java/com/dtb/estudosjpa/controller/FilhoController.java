package com.dtb.estudosjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtb.estudosjpa.model.entities.Filho;
import com.dtb.estudosjpa.service.FilhoService;

@RestController
@RequestMapping("/filho")
public class FilhoController {
	@Autowired
	private FilhoService service;
	
	@GetMapping
	public ResponseEntity<List<Filho>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Filho> save(@RequestBody Filho filho){
		return new ResponseEntity<Filho>(service.save(filho), HttpStatus.CREATED);
	}
}

package com.dtb.estudosjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtb.estudosjpa.model.entities.Pai;
import com.dtb.estudosjpa.service.PaiService;

@RestController
@RequestMapping("/pai")
public class PaiController {
	@Autowired 
	private PaiService service;
	
	@GetMapping
	public ResponseEntity<List<Pai>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pai> findById(@PathVariable("id") Long id){
		return ResponseEntity.ok(service.findById(id).get());
	}
	
	@PostMapping
	public ResponseEntity<Pai> save(@RequestBody Pai pai){
		return new ResponseEntity<Pai>(service.save(pai), HttpStatus.CREATED);
	}
}

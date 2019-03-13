package com.dtb.estudosjpa.model.dtos;

import java.util.List;

public class PaiComFilhosDto {
	private Long id;
	private String nome;
	private List<FIlhoNomeDto> filhos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<FIlhoNomeDto> getFilhos() {
		return filhos;
	}

	public void setFilhos(List<FIlhoNomeDto> filhos) {
		this.filhos = filhos;
	}

}

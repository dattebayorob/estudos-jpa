package com.dtb.estudosjpa.model.dtos;

public class FilhoDto {
	private Long id;
	private String nome;
	private Long paiId;
	private String paiNome;

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

	public Long getPaiId() {
		return paiId;
	}

	public void setPaiId(Long paiId) {
		this.paiId = paiId;
	}

	public String getPaiNome() {
		return paiNome;
	}

	public void setPaiNome(String paiNome) {
		this.paiNome = paiNome;
	}

}

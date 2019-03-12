package com.dtb.estudosjpa.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pai")
public class Pai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "pai", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Filho> filhos;

	@Column(name = "nome", nullable = false)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Filho> getFilhos() {
		if (filhos == null)
				filhos = new ArrayList<>();
		return filhos;
	}

	public void setFilhos(List<Filho> filhos) {
		this.filhos = filhos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

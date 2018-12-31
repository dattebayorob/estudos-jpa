package com.dtb.estudosjpa.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "amizade")
public class Amizade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pessoa_amigo_id")
	private Pessoa amigo;
	@Column(name = "inicio_amizade", nullable = false)
	private Date inicioAmizade;
	@Column(name = "fim_amizade")
	private Date fimAmizade;
	public Amizade() {
		
	}
	public Amizade(Pessoa pessoa, Pessoa amigo) {
		this.pessoa = pessoa;
		this.amigo = amigo;
	}
	public Amizade(Long id, Pessoa pessoa, Pessoa amigo) {
		this.id = id;
		this.pessoa = pessoa;
		this.amigo = amigo;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getAmigo() {
		return amigo;
	}

	public void setAmigo(Pessoa amigo) {
		this.amigo = amigo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Date getInicioAmizade() {
		return inicioAmizade;
	}

	public void setInicioAmizade(Date inicioAmizade) {
		this.inicioAmizade = inicioAmizade;
	}
	@PrePersist
	public void prePersist() {
		this.inicioAmizade = new Date();
	}

	public Date getFimAmizade() {
		return fimAmizade;
	}

	public void setFimAmizade(Date fimAmizade) {
		this.fimAmizade = fimAmizade;
	}

}

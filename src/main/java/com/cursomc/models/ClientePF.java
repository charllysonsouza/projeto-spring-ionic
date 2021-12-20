package com.cursomc.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_clientePF")
public class ClientePF extends Cliente {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	
	public ClientePF() {
	}

	public ClientePF(Integer id, String nome, String email, String cpf, String dataNascimento) {
		super(id, email);
		this.nome = nome;
		this.cpf = cpf;
		this.setDataNascimento(dataNascimento);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.dataNascimento = LocalDate.parse(dataNascimento, formatter);
	}
}

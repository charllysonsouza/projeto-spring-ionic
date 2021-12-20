package com.cursomc.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_clientePJ")
public class ClientePJ extends Cliente {

	private static final long serialVersionUID = 1L;
	
	private String razaoSocial;
	private String cnpj;
	private LocalDate dataFundacao;
	
	public ClientePJ() {
		
	}

	public ClientePJ(Integer id, String razaoSocial, String cnpj, String email, String dataFundacao) {
		super(id, email);
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		setDataFundacao(dataFundacao);
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(String dataFundacao) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.dataFundacao = LocalDate.parse(dataFundacao, formatter);
	}
}

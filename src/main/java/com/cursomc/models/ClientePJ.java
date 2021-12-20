package com.cursomc.models;

import java.time.LocalDate;

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

	public ClientePJ(Integer id, String email, String razaoSocial, String cnpj, LocalDate dataFundacao) {
		super(id, email);
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
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

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
}

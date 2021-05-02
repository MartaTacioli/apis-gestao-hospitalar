package com.gestaoclinica.apis.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

@Entity
@Table (name = "TB_FORNECEDOR",
uniqueConstraints=
@UniqueConstraint(columnNames={"fornecedor"})
)
public class Fornecedor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String fornecedor;
	
	
	private String endereco;
	
	private String email;
	
	private String telefone;
	

	private String whatsApp;
	
	@NotEmpty
	private String pessoaContato;
	
	public Fornecedor() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getWhatsApp() {
		return whatsApp;
	}

	public void setWhatsApp(String whatsApp) {
		this.whatsApp = whatsApp;
	}

	public String getPessoaContato() {
		return pessoaContato;
	}

	public void setPessoaContato(String pessoaContato) {
		this.pessoaContato = pessoaContato;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Fornecedor(Long id, @NotEmpty String fornecedor, String endereco, String email, String telefone,
			String whatsApp, @NotEmpty String pessoaContato) {
		super();
		this.id = id;
		this.fornecedor = fornecedor;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.whatsApp = whatsApp;
		this.pessoaContato = pessoaContato;
	}
	
	

	
}

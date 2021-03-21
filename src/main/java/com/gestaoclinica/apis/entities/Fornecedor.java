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
	
	@NotEmpty
	private String endereco;
	
	@NotEmpty
	private String email;
	
	
	public Fornecedor() {
		
	}
	
	public Fornecedor(Long id, @NotEmpty String fornecedor) {
		super();
		this.id = id;
		this.fornecedor = fornecedor;
	}
	
	public Long getId() {
		return id;
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

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	

	
}

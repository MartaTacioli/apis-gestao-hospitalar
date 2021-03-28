package com.gestaoclinica.apis.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "TB_CENTRO_CUSTO",uniqueConstraints=
@UniqueConstraint(columnNames={"cnpj"})
)
public class CentroDeCusto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String centroCusto;
	@NotEmpty
	private String cnpj;
	
	private Usuario usuario;
	
	
	public CentroDeCusto() {
		
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getCentroCusto() {
		return centroCusto;
	}




	public void setCentroCusto(String centroCusto) {
		this.centroCusto = centroCusto;
	}




	public String getCnpj() {
		return cnpj;
	}




	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}




	public Usuario getUsuario() {
		return usuario;
	}




	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

	
}

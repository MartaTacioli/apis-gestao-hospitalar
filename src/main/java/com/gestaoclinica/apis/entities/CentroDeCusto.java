package com.gestaoclinica.apis.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "TB_CENTRO_CUSTO")
public class CentroDeCusto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String bloco;
	private String detalhes;
	@NotNull
	@OneToOne
	private Sala sala;
	@NotNull
	private String cnpj;
	
	
	public CentroDeCusto() {
		
	}









	public String getCnpj() {
		return cnpj;
	}









	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}









	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getBloco() {
		return bloco;
	}




	public void setBloco(String bloco) {
		this.bloco = bloco;
	}




	public String getDetalhes() {
		return detalhes;
	}




	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}




	public Sala getSala() {
		return sala;
	}




	public void setSala(Sala sala) {
		this.sala = sala;
	}



	
	

	
}

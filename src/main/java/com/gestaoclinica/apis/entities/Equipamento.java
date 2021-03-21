package com.gestaoclinica.apis.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_EQUIPAMENTO", uniqueConstraints = @UniqueConstraint(columnNames = { "equipamento" }))
public class Equipamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String equipamento;

	@OneToMany (mappedBy = "equipamento")
	@JsonIgnore
	private List<Modelo> modelo = new ArrayList<>();
	
	
	public Equipamento() {

	}


	public Equipamento(@NotEmpty String equipamento, List<Modelo> modelo) {
		this.equipamento = equipamento;
		this.modelo = modelo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEquipamento() {
		return equipamento;
	}


	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}


	public List<Modelo> getModelo() {
		return modelo;
	}


	public void setModelo(List<Modelo> modelo) {
		this.modelo = modelo;
	}



	

}

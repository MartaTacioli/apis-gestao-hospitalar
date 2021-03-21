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
@Table(name = "TB_EQUIPAMENTO", uniqueConstraints = @UniqueConstraint(columnNames = { "inventario" }))
public class Equipamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String inventario;

	@OneToMany (mappedBy = "inventario")
	@JsonIgnore
	private List<Modelo> modelo = new ArrayList<>();
	
	
	public Equipamento() {

	}


	public Equipamento(@NotEmpty String inventario, List<Modelo> modelo) {
		this.inventario = inventario;
		this.modelo = modelo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEquipamento() {
		return inventario;
	}


	public void setEquipamento(String inventario) {
		this.inventario = inventario;
	}


	public List<Modelo> getModelo() {
		return modelo;
	}


	public void setModelo(List<Modelo> modelo) {
		this.modelo = modelo;
	}



	

}

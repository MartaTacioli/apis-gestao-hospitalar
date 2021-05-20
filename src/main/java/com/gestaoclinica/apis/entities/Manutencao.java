package com.gestaoclinica.apis.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "TB_MANUTENCAO")
public class Manutencao implements Serializable{
	private static long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@NotNull
	private String tipoManutencao;
	@NotNull
	@OneToOne
	private Usuario usuario;
	@NotNull
	@OneToOne
	private Inventario inventario;
	@NotNull
	private String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
	private String observacoes;

	public Manutencao() {
		
	}
	
	

	public Manutencao(String tipoManutencao, Usuario usuario, Inventario inventario, String data, String observacoes) {
		super();
		this.tipoManutencao = tipoManutencao;
		this.usuario = usuario;
		this.inventario = inventario;
		this.data = data;
		this.observacoes = observacoes;
	}



	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		Manutencao.serialVersionUID = serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoManutencao() {
		return tipoManutencao;
	}

	public void setTipoManutencao(String tipoManutencao) {
		this.tipoManutencao = tipoManutencao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	
	
	
	
}

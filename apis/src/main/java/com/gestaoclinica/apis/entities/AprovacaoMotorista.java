package com.gestaoclinica.apis.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "TB_APROVACAO_MOTORISTA")
public class AprovacaoMotorista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotNull
	private Long cnpjUsuario;
	
	@NotNull
	private Long cpfMotorista;

	@NotNull
	private int aprovado;

	

	public AprovacaoMotorista() {

	}


	public AprovacaoMotorista(@NotNull Long cnpjUsuario, @NotNull Long cpfMotorista, @NotNull int aprovado) {
		super();
		this.cnpjUsuario = cnpjUsuario;
		this.cpfMotorista = cpfMotorista;
		this.aprovado = aprovado;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getCnpjUsuario() {
		return cnpjUsuario;
	}

	public void setCnpjUsuario(Long cnpjUsuario) {
		this.cnpjUsuario = cnpjUsuario;
	}

	public Long getCpfMotorista() {
		return cpfMotorista;
	}

	public void setCpfMotorista(Long cpfMotorista) {
		this.cpfMotorista = cpfMotorista;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getAprovado() {
		return aprovado;
	}

	public void setAprovado(int aprovado) {
		this.aprovado = aprovado;
	}

	@Override
	public String toString() {
		return "AprovacaoMotorista [Id=" + Id + ", cnpjUsuario=" + cnpjUsuario + ", cpfMotorista="
				+ cpfMotorista + ", aprovado=" + aprovado + "]";
	}
	
	
	
	




	
	
}

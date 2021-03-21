package com.gestaoclinica.apis.entities.matrix;

public class RequestLoginMotorista {
	
	private Long cpf_motorista;
	
	private String cnpj_Usuario;
	private String nome;
	private String email;
	private String password;
	private String placa;
	private int aprovado;
	
	public RequestLoginMotorista() {
		
	}
	
	



	public RequestLoginMotorista(Long cpf_motorista, String cnpj_Usuario, String nome, String email,
			String password, String placa) {
		super();
		this.cpf_motorista = cpf_motorista;
		this.cnpj_Usuario = cnpj_Usuario;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.placa = placa;
	}





	public Long getCpf_motorista() {
		return cpf_motorista;
	}



	public void setCpf_motorista(Long cpf_motorista) {
		this.cpf_motorista = cpf_motorista;
	}



	public int getAprovado() {
		return aprovado;
	}





	public void setAprovado(int aprovado) {
		this.aprovado = aprovado;
	}





	public String getCnpj_Usuario() {
		return cnpj_Usuario;
	}

	public void setCnpj_Usuario(String cnpj_Usuario) {
		this.cnpj_Usuario = cnpj_Usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}


	
	
	
}

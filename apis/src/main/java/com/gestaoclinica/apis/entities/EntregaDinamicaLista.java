package com.gestaoclinica.apis.entities;

public interface EntregaDinamicaLista{
	Long id();
	Long cnpjUsuario();
	Long cpfMotorista();
	String statusEntrega();
	Filial filial();
	double valorCorrida();
	boolean valorCorridaReajustado();
	double previsaoKilometragem();

}

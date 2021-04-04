package com.gestaoclinica.apis.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_INVENTARIO")
public class Inventario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@ManyToOne
	@JoinColumn(name = "modelo_id")
	private Modelo modelo;
	
	@OneToOne
	@NotNull
	private Fornecedor fornecedor;
	
	private Usuario usuario;
	private String descricao;
	private String fabricante;
	private String centroCusto;
	private Double valorCompra;
	private Double taxaDepreciacao;
	private String notaFiscal;
	private Double codigoProduto;
	private Double numeroSerie;
	private String anoAquisicao;
	private String inicioGarantia;
	private String expiracaoGarantia;
	private Boolean utilizaGases;
	private String quaisGases;
	private Boolean alimentacaoHidraulica;
	private Boolean utilizaAcessorios;
	private String quaisAcessorios;
	private Double alimentacaoEletrica;
	private String registroAnvisa;
	private Date anoFabricacao;
	private Double peso;
	private Double comprimento;
	private Double altura;
	private Double corrente;
	private Double potencia;
	private Double largura;
	private Date dataCompra;
	private String observacao;
	private String qrCode;
	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public String getQrCode() {
		return qrCode;
	}


	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}


	@NotNull
	private Date dataCadastramento = new Date();

	
	public Inventario() {

	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}





	public Modelo getModelo() {
		return modelo;
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}


	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getFabricante() {
		return fabricante;
	}


	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}


	public String getCentroCusto() {
		return centroCusto;
	}


	public void setCentroCusto(String centroCusto) {
		this.centroCusto = centroCusto;
	}


	public Double getValorCompra() {
		return valorCompra;
	}


	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}


	public Double getTaxaDepreciacao() {
		return taxaDepreciacao;
	}


	public void setTaxaDepreciacao(Double taxaDepreciacao) {
		this.taxaDepreciacao = taxaDepreciacao;
	}


	public String getNotaFiscal() {
		return notaFiscal;
	}


	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}


	public Double getCodigoProduto() {
		return codigoProduto;
	}


	public void setCodigoProduto(Double codigoProduto) {
		this.codigoProduto = codigoProduto;
	}


	public Double getNumeroSerie() {
		return numeroSerie;
	}


	public void setNumeroSerie(Double numeroSerie) {
		this.numeroSerie = numeroSerie;
	}


	public String getAnoAquisicao() {
		return anoAquisicao;
	}


	public void setAnoAquisicao(String anoAquisicao) {
		this.anoAquisicao = anoAquisicao;
	}


	public String getInicioGarantia() {
		return inicioGarantia;
	}


	public void setInicioGarantia(String inicioGarantia) {
		this.inicioGarantia = inicioGarantia;
	}


	public String getExpiracaoGarantia() {
		return expiracaoGarantia;
	}


	public void setExpiracaoGarantia(String expiracaoGarantia) {
		this.expiracaoGarantia = expiracaoGarantia;
	}


	public String getRegistroAnvisa() {
		return registroAnvisa;
	}


	public void setRegistroAnvisa(String registroAnvisa) {
		this.registroAnvisa = registroAnvisa;
	}


	public Date getAnoFabricacao() {
		return anoFabricacao;
	}


	public void setAnoFabricacao(Date anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}


	public Date getDataCompra() {
		return dataCompra;
	}


	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}


	public Date getDataCadastramento() {
		return dataCadastramento;
	}


	public void setDataCadastramento(Date dataCadastramento) {
		this.dataCadastramento = dataCadastramento;
	}
	
	


	public Boolean getUtilizaGases() {
		return utilizaGases;
	}


	public void setUtilizaGases(Boolean utilizaGases) {
		this.utilizaGases = utilizaGases;
	}


	public String getQuaisGases() {
		return quaisGases;
	}


	public void setQuaisGases(String quaisGases) {
		this.quaisGases = quaisGases;
	}


	public Boolean getAlimentacaoHidraulica() {
		return alimentacaoHidraulica;
	}


	public void setAlimentacaoHidraulica(Boolean alimentacaoHidraulica) {
		this.alimentacaoHidraulica = alimentacaoHidraulica;
	}


	public Boolean getUtilizaAcessorios() {
		return utilizaAcessorios;
	}


	public void setUtilizaAcessorios(Boolean utilizaAcessorios) {
		this.utilizaAcessorios = utilizaAcessorios;
	}


	public String getQuaisAcessorios() {
		return quaisAcessorios;
	}


	public void setQuaisAcessorios(String quaisAcessorios) {
		this.quaisAcessorios = quaisAcessorios;
	}


	public Double getAlimentacaoEletrica() {
		return alimentacaoEletrica;
	}


	public void setAlimentacaoEletrica(Double alimentacaoEletrica) {
		this.alimentacaoEletrica = alimentacaoEletrica;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}


	public Double getComprimento() {
		return comprimento;
	}


	public void setComprimento(Double comprimento) {
		this.comprimento = comprimento;
	}


	public Double getAltura() {
		return altura;
	}


	public void setAltura(Double altura) {
		this.altura = altura;
	}


	public Double getCorrente() {
		return corrente;
	}


	public void setCorrente(Double corrente) {
		this.corrente = corrente;
	}


	public Double getPotencia() {
		return potencia;
	}


	public void setPotencia(Double potencia) {
		this.potencia = potencia;
	}


	public Double getLargura() {
		return largura;
	}


	public void setLargura(Double largura) {
		this.largura = largura;
	}




	

}

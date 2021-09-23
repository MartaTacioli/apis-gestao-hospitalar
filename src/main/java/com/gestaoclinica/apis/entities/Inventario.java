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
import javax.validation.constraints.NotEmpty;
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
	
	@OneToOne
	@NotNull
	private CentroDeCusto centroDeCusto;
	
	private Usuario usuario;
	private String descricao;
	private String fabricante;
	private String valorCompra;
	private String taxaDepreciacao;
	private String notaFiscal;
	private String codigoProduto;
	private String numeroSerie;
	private String anoAquisicao;
	private String inicioGarantia;
	private String expiracaoGarantia;
	private Boolean utilizaGases;
	private String quaisGases;
	private Boolean alimentacaoHidraulica;
	private Boolean utilizaAcessorios;
	private String quaisAcessorios;
	private String alimentacaoEletrica;
	private String patrimonio;

	private String registroAnvisa;
	private Date anoFabricacao;
	private String peso;
	private String comprimento;
	private String altura;
	private String corrente;
	private String potencia;
	private String largura;
	private Date dataCompra;
	private String observacao;
	@NotEmpty
	private String instrucoesSegurancaEletrica;
	@NotEmpty
	private String instrucoesPredial;
	
	
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
	public CentroDeCusto getCentroDeCusto() {
		return centroDeCusto;
	}
	public void setCentroDeCusto(CentroDeCusto centroDeCusto) {
		this.centroDeCusto = centroDeCusto;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
	public String getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(String valorCompra) {
		this.valorCompra = valorCompra;
	}
	public String getTaxaDepreciacao() {
		return taxaDepreciacao;
	}
	public void setTaxaDepreciacao(String taxaDepreciacao) {
		this.taxaDepreciacao = taxaDepreciacao;
	}
	public String getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
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
	public String getAlimentacaoEletrica() {
		return alimentacaoEletrica;
	}
	public void setAlimentacaoEletrica(String alimentacaoEletrica) {
		this.alimentacaoEletrica = alimentacaoEletrica;
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
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getComprimento() {
		return comprimento;
	}
	public void setComprimento(String comprimento) {
		this.comprimento = comprimento;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getCorrente() {
		return corrente;
	}
	public void setCorrente(String corrente) {
		this.corrente = corrente;
	}
	public String getPotencia() {
		return potencia;
	}
	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}
	public String getLargura() {
		return largura;
	}
	public void setLargura(String largura) {
		this.largura = largura;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getInstrucoesSegurancaEletrica() {
		return instrucoesSegurancaEletrica;
	}
	public void setInstrucoesSegurancaEletrica(String instrucoesSegurancaEletrica) {
		this.instrucoesSegurancaEletrica = instrucoesSegurancaEletrica;
	}
	public String getInstrucoesPredial() {
		return instrucoesPredial;
	}
	public void setInstrucoesPredial(String instrucoesPredial) {
		this.instrucoesPredial = instrucoesPredial;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getPatrimonio() {
		return patrimonio;
	}
	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}
	
	
	

}

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_INVENTARIO", uniqueConstraints = @UniqueConstraint(columnNames = { "inventario" }))
public class Inventario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String inventario;

	@ManyToOne
	@JoinColumn(name = "modelo_id")
	private Modelo modelo;
	
	@OneToOne
	@NotNull
	private Fornecedor fornecedor;
	
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
	private String registroAnvisa;
	private Date anoFabricacao;
	private Date dataCompra;
	
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


	public String getInventario() {
		return inventario;
	}


	public void setInventario(String inventario) {
		this.inventario = inventario;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	

}

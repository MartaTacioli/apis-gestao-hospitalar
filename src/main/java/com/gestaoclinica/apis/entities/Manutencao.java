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
	@OneToOne
	private Inventario inventario;
	@NotNull
	private String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
	private String descricaoDetalhadaServico;
	private String descricaoDetalhadaAprovador;
	private String descricaoDetalhadaExecutor;
	private Boolean falhaEquipamento;
	private Boolean falhaAcessorio;
	private Boolean manutencaoPreventiva;
	private Boolean manutencaoCorretiva;
	private Boolean segurancaEletrica;
	private String dataManutencao;
	private String dataAprovacao;
	private Boolean calibracao;
	private Boolean treinamento;
	private Boolean instalacao;
	private Long usuarioServico;
	private Long usuarioAprovador;
	private int aprovado;
	private String manutencaoLocalRetiradaExterna;
	private String equipamentoOperanteRessalvaNao;
	private String tipoOs;
	private Long usuarioExecutor;
	private String comentarioExecutorInstalacao;
	private String comentarioExecutorManutencaoPreventiva;
	private String comentarioExecutorTreinamento;
	private String comentarioExecutorManutencaoCorretiva;
	private String comentarioExecutorManutencaoCalibracao;
	private String comentarioExecutorSegurancaEletrica;
;


	public Manutencao() {
		
	}

	







	public Manutencao(@NotNull Inventario inventario, @NotNull String data, String descricaoDetalhadaServico,
			String descricaoDetalhadaAprovador, String descricaoDetalhadaExecutor, Boolean falhaEquipamento,
			Boolean falhaAcessorio, Boolean manutencaoPreventiva, Boolean manutencaoCorretiva,
			Boolean segurancaEletrica, Boolean calibracao, Boolean treinamento, Boolean instalacao, Long usuarioServico,
			Long usuarioAprovador, Long usuarioExecutor, int aprovado, String manutencaoLocalRetiradaExterna,
			String equipamentoOperanteRessalvaNao, String tipoOs) {
		super();
		this.inventario = inventario;
		this.data = data;
		this.descricaoDetalhadaServico = descricaoDetalhadaServico;
		this.descricaoDetalhadaAprovador = descricaoDetalhadaAprovador;
		this.descricaoDetalhadaExecutor = descricaoDetalhadaExecutor;
		this.falhaEquipamento = falhaEquipamento;
		this.falhaAcessorio = falhaAcessorio;
		this.manutencaoPreventiva = manutencaoPreventiva;
		this.manutencaoCorretiva = manutencaoCorretiva;
		this.segurancaEletrica = segurancaEletrica;
		this.calibracao = calibracao;
		this.treinamento = treinamento;
		this.instalacao = instalacao;
		this.usuarioServico = usuarioServico;
		this.usuarioAprovador = usuarioAprovador;
		this.usuarioExecutor = usuarioExecutor;
		this.aprovado = aprovado;
		this.manutencaoLocalRetiradaExterna = manutencaoLocalRetiradaExterna;
		this.equipamentoOperanteRessalvaNao = equipamentoOperanteRessalvaNao;
		this.tipoOs = tipoOs;
	}









	public Boolean getTreinamento() {
		return treinamento;
	}






	public String getComentarioExecutorInstalacao() {
		return comentarioExecutorInstalacao;
	}









	public void setComentarioExecutorInstalacao(String comentarioExecutorInstalacao) {
		this.comentarioExecutorInstalacao = comentarioExecutorInstalacao;
	}









	public String getComentarioExecutorTreinamento() {
		return comentarioExecutorTreinamento;
	}









	public void setComentarioExecutorTreinamento(String comentarioExecutorTreinamento) {
		this.comentarioExecutorTreinamento = comentarioExecutorTreinamento;
	}









	public String getComentarioExecutorManutencaoCalibracao() {
		return comentarioExecutorManutencaoCalibracao;
	}









	public void setComentarioExecutorManutencaoCalibracao(String comentarioExecutorManutencaoCalibracao) {
		this.comentarioExecutorManutencaoCalibracao = comentarioExecutorManutencaoCalibracao;
	}









	public String getComentarioExecutorSegurancaEletrica() {
		return comentarioExecutorSegurancaEletrica;
	}









	public void setComentarioExecutorSegurancaEletrica(String comentarioExecutorSegurancaEletrica) {
		this.comentarioExecutorSegurancaEletrica = comentarioExecutorSegurancaEletrica;
	}









	public void setTreinamento(Boolean treinamento) {
		this.treinamento = treinamento;
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

	public String getDescricaoDetalhadaServico() {
		return descricaoDetalhadaServico;
	}

	public void setDescricaoDetalhadaServico(String descricaoDetalhadaServico) {
		this.descricaoDetalhadaServico = descricaoDetalhadaServico;
	}

	public String getDescricaoDetalhadaAprovador() {
		return descricaoDetalhadaAprovador;
	}

	public void setDescricaoDetalhadaAprovador(String descricaoDetalhadaAprovador) {
		this.descricaoDetalhadaAprovador = descricaoDetalhadaAprovador;
	}

	public String getDescricaoDetalhadaExecutor() {
		return descricaoDetalhadaExecutor;
	}

	public void setDescricaoDetalhadaExecutor(String descricaoDetalhadaExecutor) {
		this.descricaoDetalhadaExecutor = descricaoDetalhadaExecutor;
	}

	public Boolean getFalhaEquipamento() {
		return falhaEquipamento;
	}

	public void setFalhaEquipamento(Boolean falhaEquipamento) {
		this.falhaEquipamento = falhaEquipamento;
	}

	public Boolean getFalhaAcessorio() {
		return falhaAcessorio;
	}

	public void setFalhaAcessorio(Boolean falhaAcessorio) {
		this.falhaAcessorio = falhaAcessorio;
	}

	public Boolean getManutencaoPreventiva() {
		return manutencaoPreventiva;
	}

	public void setManutencaoPreventiva(Boolean manutencaoPreventiva) {
		this.manutencaoPreventiva = manutencaoPreventiva;
	}

	public Boolean getManutencaoCorretiva() {
		return manutencaoCorretiva;
	}

	public void setManutencaoCorretiva(Boolean manutencaoCorretiva) {
		this.manutencaoCorretiva = manutencaoCorretiva;
	}

	public Boolean getCalibracao() {
		return calibracao;
	}

	public void setCalibracao(Boolean calibracao) {
		this.calibracao = calibracao;
	}

	public Boolean getInstalacao() {
		return instalacao;
	}

	public void setInstalacao(Boolean instalacao) {
		this.instalacao = instalacao;
	}

	public Long getUsuarioServico() {
		return usuarioServico;
	}

	public void setUsuarioServico(Long usuarioServico) {
		this.usuarioServico = usuarioServico;
	}

	public Long getUsuarioAprovador() {
		return usuarioAprovador;
	}

	public void setUsuarioAprovador(Long usuarioAprovador) {
		this.usuarioAprovador = usuarioAprovador;
	}

	public Long getUsuarioExecutor() {
		return usuarioExecutor;
	}

	public void setUsuarioExecutor(Long usuarioExecutor) {
		this.usuarioExecutor = usuarioExecutor;
	}

	public int getAprovado() {
		return aprovado;
	}

	public void setAprovado(int aprovado) {
		this.aprovado = aprovado;
	}

	public String getManutencaoLocalRetiradaExterna() {
		return manutencaoLocalRetiradaExterna;
	}

	public void setManutencaoLocalRetiradaExterna(String manutencaoLocalRetiradaExterna) {
		this.manutencaoLocalRetiradaExterna = manutencaoLocalRetiradaExterna;
	}

	public String getEquipamentoOperanteRessalvaNao() {
		return equipamentoOperanteRessalvaNao;
	}

	public void setEquipamentoOperanteRessalvaNao(String equipamentoOperanteRessalvaNao) {
		this.equipamentoOperanteRessalvaNao = equipamentoOperanteRessalvaNao;
	}

	public String getTipoOs() {
		return tipoOs;
	}

	public void setTipoOs(String tipoOs) {
		this.tipoOs = tipoOs;
	}






	public Boolean getSegurancaEletrica() {
		return segurancaEletrica;
	}






	public void setSegurancaEletrica(Boolean segurancaEletrica) {
		this.segurancaEletrica = segurancaEletrica;
	}









	public String getDataManutencao() {
		return dataManutencao;
	}









	public String getComentarioExecutorManutencaoCorretiva() {
		return comentarioExecutorManutencaoCorretiva;
	}









	public void setComentarioExecutorManutencaoCorretiva(String comentarioExecutorManutencaoCorretiva) {
		this.comentarioExecutorManutencaoCorretiva = comentarioExecutorManutencaoCorretiva;
	}









	public String getComentarioExecutorManutencaoPreventiva() {
		return comentarioExecutorManutencaoPreventiva;
	}









	public void setComentarioExecutorManutencaoPreventiva(String comentarioExecutorManutencaoPreventiva) {
		this.comentarioExecutorManutencaoPreventiva = comentarioExecutorManutencaoPreventiva;
	}

















	public String getDataAprovacao() {
		return dataAprovacao;
	}









	public void setDataAprovacao(String dataAprovacao) {
		this.dataAprovacao = dataAprovacao;
	}










	public void setDataManutencao(String dataManutencao) {
		this.dataManutencao = dataManutencao;
	}
	
	
	
	

	
	
	

	
	
	
	
}

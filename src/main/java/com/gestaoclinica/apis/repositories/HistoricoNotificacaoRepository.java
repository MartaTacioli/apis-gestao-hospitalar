package com.gestaoclinica.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.HistoricoNotificacao;
import com.gestaoclinica.apis.entities.Usuario;

public interface HistoricoNotificacaoRepository extends JpaRepository<HistoricoNotificacao, Long> {
	void deleteById(Long id);
	List<HistoricoNotificacao> findAllByUsuario(Usuario usuario);
	
}

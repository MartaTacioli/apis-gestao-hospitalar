package com.gestaoclinica.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.Notificacao;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
	Notificacao findByUsuario(Long usuario);
	void deleteById(Long id);

}

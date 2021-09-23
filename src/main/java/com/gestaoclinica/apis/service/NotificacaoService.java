package com.gestaoclinica.apis.service;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gestaoclinica.apis.entities.Notificacao;
import com.gestaoclinica.apis.repositories.NotificacaoRepository;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;

@Service
public class NotificacaoService {

	@Autowired
	private NotificacaoRepository repository;

	public Notificacao findByUsuario(Long cpf) {

		return repository.findByUsuario(cpf);

	}

	public Notificacao insert(Notificacao obj) {
		try {
			repository.save(obj);
		} catch (DataIntegrityViolationException e) {
			Notificacao objNot = repository.findByUsuario(obj.getUsuario());
			repository.deleteById(objNot.getId());
			repository.save(obj);

		} catch (ConstraintViolationException e) {
			throw new CamposObrigatoriosException(null,"Campos obrigatórios devem ser preenchidos.");
			
		} catch (RuntimeException e) {
			throw new ErroNaoMapeadoException("");
		}
		return obj;

	}


}

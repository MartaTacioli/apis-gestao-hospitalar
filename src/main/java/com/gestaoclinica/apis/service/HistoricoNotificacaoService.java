package com.gestaoclinica.apis.service;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import com.gestaoclinica.apis.entities.HistoricoNotificacao;
import com.gestaoclinica.apis.entities.Usuario;
import com.gestaoclinica.apis.repositories.HistoricoNotificacaoRepository;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.RecursoNaoEncontradoException;
import com.gestaoclinica.apis.service.exceptions.ReferenciaExternaException;

@Service
public class HistoricoNotificacaoService {

	@Autowired
	private HistoricoNotificacaoRepository repository;

	public List<HistoricoNotificacao> findAll() {
		return repository.findAll();

	}
	public HistoricoNotificacao findById(Long id) {
		Optional<HistoricoNotificacao> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoException(id,1));
	}
	
	public List<HistoricoNotificacao> findAllByUsuario(Long cpf) {
		Usuario usuario = new Usuario();
		usuario.setCpf(cpf);
		
		return repository.findAllByUsuario(usuario);

	}

	public HistoricoNotificacao insert(HistoricoNotificacao obj) {
		try {
			repository.save(obj);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			String erro  = "Erro de referência externa. ";
			throw new ReferenciaExternaException(erro);

		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			throw new CamposObrigatoriosException(null,"Campos obrigatórios devem ser preenchidos.");
			
		} catch (RuntimeException e) {

			e.printStackTrace();
			throw new ErroNaoMapeadoException("");
		}
		return obj;

	}

	public HistoricoNotificacao delete(HistoricoNotificacao obj) {

		try {
			repository.deleteById(obj.getId());
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();

			throw new RecursoNaoEncontradoException("o esse equipamento", obj.getId());

		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();

			throw new RecursoNaoEncontradoException("o esse equipamento", obj.getId());

		}  catch (InvalidDataAccessApiUsageException e) {
			e.printStackTrace();

			throw new CamposObrigatoriosException(null,"O id do recurso a ser deletado deve ser informado.");
			
			
		} catch (RuntimeException e) {
		

			e.printStackTrace();
			throw new ErroNaoMapeadoException("");
		}
		return obj;

	}

}

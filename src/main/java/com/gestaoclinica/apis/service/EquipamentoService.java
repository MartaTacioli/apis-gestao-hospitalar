package com.gestaoclinica.apis.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import com.gestaoclinica.apis.entities.Inventario;
import com.gestaoclinica.apis.repositories.InventarioRepository;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.RecursoNaoEncontradoException;
import com.gestaoclinica.apis.service.exceptions.ReferenciaExternaException;

@Service
public class InventarioService {

	@Autowired
	private InventarioRepository repository;

	public List<Inventario> findAll() {
		return repository.findAll();

	}

	public Inventario insert(Inventario obj) {
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

	public Inventario delete(Inventario obj) {

		try {
			repository.deleteById(obj.getId());
		} catch (DataIntegrityViolationException e) {

			throw new RecursoNaoEncontradoException("o esse inventario", obj.getId());

		} catch (EmptyResultDataAccessException e) {

			throw new RecursoNaoEncontradoException("o esse inventario", obj.getId());

		}  catch (InvalidDataAccessApiUsageException e) {
			
			throw new CamposObrigatoriosException(null,"O id do recurso a ser deletado deve ser informado.");
			
			
		} catch (RuntimeException e) {
		

			e.printStackTrace();
			throw new ErroNaoMapeadoException("");
		}
		return obj;

	}

}

package com.gestaoclinica.apis.service;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gestaoclinica.apis.entities.Sala;
import com.gestaoclinica.apis.repositories.SalaRepository;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.RecursoJaCadastradoException;
import com.gestaoclinica.apis.service.exceptions.RecursoNaoEncontradoException;
import com.gestaoclinica.apis.service.exceptions.ViolacaoDeChaveException;

@Service
public class SalaService {
	
	@Autowired
	private SalaRepository repository;
	
	public List<Sala> findAllByCnpj(Long cnpj){
		return repository.findAllByCnpj(cnpj);
	}
	

	
	
	public Sala findById(Long id) {
		Optional<Sala> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoException(id,1));
	}
	
	public Sala insert (Sala obj) {
		try {
			System.out.println("entrouuuuuuuuuuuu");
			repository.save(obj);
	 	} catch (DataIntegrityViolationException e){
	 		
	 		  throw new RecursoJaCadastradoException ("Não existe esse registro.",1);			
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			throw new CamposObrigatoriosException (obj, "Caracteristica do Im�vel");
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new ErroNaoMapeadoException ("");
		}
		return obj;

}
	
	public Sala delete (Sala obj) {	
		try {
		 repository.deleteById(obj.getId());
		} catch (DataIntegrityViolationException e){
	 		 e.printStackTrace();
			  throw new ViolacaoDeChaveException ("Esse recurso esta sendo utilizado!");
				
			} catch(EmptyResultDataAccessException e){
				 e.printStackTrace();
				  throw new RecursoJaCadastradoException ("Não existe esse registro.",1);

			}catch (RuntimeException e) {
			
				e.printStackTrace();
				throw new ErroNaoMapeadoException ("");
			}
		return obj;
	
	}
	
}

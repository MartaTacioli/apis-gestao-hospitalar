package com.gestaoclinica.apis.service;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gestaoclinica.apis.entities.CentroDeCusto;
import com.gestaoclinica.apis.repositories.CentroDeCustoRepository;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.RecursoJaCadastradoException;
import com.gestaoclinica.apis.service.exceptions.RecursoNaoEncontradoException;
import com.gestaoclinica.apis.service.exceptions.ViolacaoDeChaveException;

@Service
public class CentroDeCustoService {
	
	@Autowired
	private CentroDeCustoRepository repository;
	
	public List<CentroDeCusto> findAllByCnpj(String cnpj){
		System.out.println("findAllByCnpj entrou aqui doidção" + cnpj);
		return repository.findAllByCnpj(cnpj);
	}
	

	
	public CentroDeCusto findById(Long id) {
		Optional<CentroDeCusto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoException(id,1));
	}
	
	public CentroDeCusto insert (CentroDeCusto obj) {
		try {
			repository.save(obj);
	 	} catch (DataIntegrityViolationException e){
	 		
	 		  throw new RecursoJaCadastradoException ("N�o existe esse registro.",1);			
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			throw new CamposObrigatoriosException (obj, "Caracteristica do Im�vel");
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new ErroNaoMapeadoException ("");
		}
		return obj;

}
	
	public CentroDeCusto delete (CentroDeCusto obj) {	
		try {
		 repository.deleteById(obj.getId());
		} catch (DataIntegrityViolationException e){
	 		 e.printStackTrace();
			  throw new ViolacaoDeChaveException ("Esse recurso esta sendo utilizado!");
				
			} catch(EmptyResultDataAccessException e){
				 e.printStackTrace();
				  throw new RecursoJaCadastradoException ("N�o existe esse registro.",1);

			}catch (RuntimeException e) {
			
				e.printStackTrace();
				throw new ErroNaoMapeadoException ("");
			}
		return obj;
	
	}
	
}

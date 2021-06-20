package com.gestaoclinica.apis.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.gestaoclinica.apis.entities.Inventario;
import com.gestaoclinica.apis.entities.Manutencao;
import com.gestaoclinica.apis.entities.Usuario;
import com.gestaoclinica.apis.repositories.ManutencaoRepository;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.RecursoNaoEncontradoException;
import com.gestaoclinica.apis.service.exceptions.ReferenciaExternaException;
import com.gestaoclinica.apis.service.exceptions.ViolacaoDeChaveException;

@Service
public class ManutencaoService {

	@Autowired
	private ManutencaoRepository repository;


	public Manutencao findById(Long id) {
		Optional<Manutencao> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoException(id,1));
	}
	
	public List<Manutencao> findAllByUsuario(Long cpf) {
		Usuario usuario = new Usuario();
		usuario.setCpf(cpf);
		
		return repository.findAllByUsuarioExecutor(cpf);

	}
	public List<Manutencao> findAllByUsuarioServico(Long cpf) {
		
		return repository.findAllByUsuarioServico(cpf);

	}
	
	
	public List<Manutencao> findAllByInventario(Long id) {
		Inventario inventario = new Inventario();
		inventario.setId(id);
		
		return repository.findAllByInventario(inventario);

	}

	public Manutencao insert(Manutencao obj) {
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

	public Manutencao delete(Manutencao obj) {

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
	

	public Manutencao aprovarManutencao (Manutencao obj) {
		try {

			Optional<Manutencao> objManutencao = repository.findById(obj.getId());

		        Manutencao objAlterado = new Manutencao();
		        objAlterado = objManutencao.get();
		        objAlterado.setManutencaoLocalRetiradaExterna(obj.getManutencaoLocalRetiradaExterna());
		        objAlterado.setAprovado(1);
		        objAlterado.setInstalacao(obj.getInstalacao());
		        objAlterado.setManutencaoPreventiva(obj.getManutencaoPreventiva());
		        objAlterado.setSegurancaEletrica(obj.getSegurancaEletrica());
		        objAlterado.setManutencaoCorretiva(obj.getManutencaoCorretiva());
		        objAlterado.setTreinamento(obj.getTreinamento());
		        objAlterado.setCalibracao(obj.getCalibracao());
		        objAlterado.setFalhaAcessorio(obj.getFalhaAcessorio());
		        objAlterado.setFalhaEquipamento(obj.getFalhaEquipamento());
		        objAlterado.setTipoOs(obj.getTipoOs());
		        objAlterado.setEquipamentoOperanteRessalvaNao(obj.getEquipamentoOperanteRessalvaNao());
		        objAlterado.setDescricaoDetalhadaAprovador(obj.getDescricaoDetalhadaAprovador());
		        
			return repository.save(objAlterado);

		} catch (TransactionSystemException e) {

			throw new ViolacaoDeChaveException("Existem campos vazios!");

		} catch (EntityNotFoundException e) {
			throw new RecursoNaoEncontradoException("O recurso a ser aprovado nao existe na base. Atualize a pagina e tente novamente.", null);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new ErroNaoMapeadoException("Erro nao mapeado na aprovacao de funcionarios.");
		}
	}
	

}

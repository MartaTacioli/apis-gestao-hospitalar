package com.gestaoclinica.apis.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.gestaoclinica.apis.entities.Login;
import com.gestaoclinica.apis.entities.Usuario;
import com.gestaoclinica.apis.entities.matrix.Nota;
import com.gestaoclinica.apis.entities.matrix.NotaRequest;
import com.gestaoclinica.apis.repositories.LoginRepository;
import com.gestaoclinica.apis.repositories.UsuarioRepository;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.RecursoJaCadastradoException;
import com.gestaoclinica.apis.service.exceptions.RecursoNaoEncontradoException;
import com.gestaoclinica.apis.service.exceptions.SenhasDiferentesException;
import com.gestaoclinica.apis.service.exceptions.ValidacaoTamanhoSenhaException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	

	@Autowired
	private LoginService loginService;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}

	
	public List<Usuario> findPendentes(){
		try {
			List<Usuario> obj = repository.findAllByAprovado(0);
			return obj;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	public Nota consultarNota(NotaRequest obj){
		
		
		return null;
		
		
	}

	public Usuario findById(Long cpf) {
		//Optional: Garante que estamos retornando o objeto no banco de dados, não apenas seus valores//
		Optional<Usuario> obj = repository.findById(cpf);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoException(cpf,1));
	}
	
	public Usuario findByCpf(Long cpf) {
		//Optional: Garante que estamos retornando o objeto no banco de dados, não apenas seus valores//
		Usuario obj = repository.findByCpf(cpf);
		return obj;
	}
	
	
	
	
	
	
	
	public List<Usuario> aprovarUsuarios(List<Usuario> obj){
		try {
		 for (Usuario transportadoraAtual : obj) {
			 Usuario entity = repository.getOne(transportadoraAtual.getCpf());
			 Login loginEntity = loginRepository.getOne(transportadoraAtual.getCpf());
			 entity.setAprovado(transportadoraAtual.getAprovado());
			 loginEntity.setAprovado(transportadoraAtual.getAprovado());
	         repository.save(entity);
	        }
		 
		} catch (EntityNotFoundException e) {
			throw new RecursoNaoEncontradoException ("O recurso a ser aprovado não existe na base. Atualize a página e tente novamente.",1);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new ErroNaoMapeadoException("Erro não mapeado na aprovação de corretores.");
		}
		return obj;
	}
	
	public Usuario insert (Usuario obj) {
	if (obj.getSenha().toString().equals(obj.getSenhaConfirm().toString())) {
		if(repository.existsById(obj.getCpf())){
			throw new RecursoJaCadastradoException(obj.getCpf().toString(),1);
		} else {
			if (obj.getSenha().length() > 5) {
			try {
				Usuario objEcp = new Usuario ();
				objEcp = obj;
				objEcp.setSenha(new BCryptPasswordEncoder().encode(obj.getSenha()));
				objEcp.setSenhaConfirm(new BCryptPasswordEncoder().encode(obj.getSenhaConfirm()));	
				obj.setAprovado(obj.getAprovado());

				loginService.saveLoginCorretor(objEcp);
				repository.save(objEcp);
							
			}catch (DataIntegrityViolationException e) {
					e.printStackTrace();
			       throw new RecursoJaCadastradoException(obj.getCpf().toString(),1);
			       
				} catch (TransactionSystemException e) {
					System.out.println("2");

					e.printStackTrace();	
					e.getCause().getStackTrace();
					throw new CamposObrigatoriosException (obj, e.getMostSpecificCause().toString());
				} catch (JpaSystemException e) {
					System.out.println("3");

					e.printStackTrace();
					throw new CamposObrigatoriosException (obj, e.getMostSpecificCause().toString());
				} 
				} else {
					throw new ValidacaoTamanhoSenhaException ("A senha deve conter no mínimo 6 caracteres!");
				}
				}
	} else {
		throw new SenhasDiferentesException ("Senhas no cadastro de corretores não estão iguais.");
	}
		
		return obj;
	}
	
	
	/*
	 * public Usuario atualizarUsuario(Usuario obj){ try {
	 * 
	 * Usuario entity = repository.findByCnpj(obj.getCnpj());
	 * entity.set(obj.getNome()); entity.setNumero(obj.getNumero());
	 * entity.setLogradouro(obj.getLogradouro()); entity.setCidade(obj.getCidade());
	 * entity.setBairro(obj.getBairro()); entity.setEstado(obj.getEstado());
	 * entity.setEmail(obj.getEmail()); entity.setCelular(obj.getCelular());
	 * entity.setCep(obj.getCep()); if (obj.getRegiao().size() >= 1) {
	 * entity.setRegiao(obj.getRegiao()); }
	 * 
	 * 
	 * return repository.save(entity);
	 * 
	 * 
	 * } catch (TransactionSystemException e) {
	 * 
	 * throw new CamposObrigatoriosException ("Existem campos vazios!", null);
	 * 
	 * } catch (EntityNotFoundException e) { throw new RecursoNaoEncontradoException
	 * ("O recurso a ser aprovado não existe na base. Atualize a página e tente novamente."
	 * ,1); } catch (RuntimeException e) { e.printStackTrace(); throw new
	 * ErroNaoMapeadoException("Erro não mapeado na aprovação de corretores."); } }
	 * 
	 * 
	 */
	
	
	
}

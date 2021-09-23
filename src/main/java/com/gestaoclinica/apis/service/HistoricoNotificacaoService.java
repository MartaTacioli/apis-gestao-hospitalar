package com.gestaoclinica.apis.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import com.gestaoclinica.apis.entities.HistoricoNotificacao;
import com.gestaoclinica.apis.entities.Manutencao;
import com.gestaoclinica.apis.entities.Notificacao;
import com.gestaoclinica.apis.entities.Usuario;
import com.gestaoclinica.apis.repositories.HistoricoNotificacaoRepository;
import com.gestaoclinica.apis.repositories.ManutencaoRepository;
import com.gestaoclinica.apis.repositories.NotificacaoRepository;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.RecursoNaoEncontradoException;
import com.gestaoclinica.apis.service.exceptions.ReferenciaExternaException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class HistoricoNotificacaoService {

	@Autowired
	private HistoricoNotificacaoRepository repository;
	@Autowired
	private NotificacaoRepository notificacaoRepository;
	@Autowired
	private ManutencaoRepository manutencaoRepository;


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

	public HistoricoNotificacao insert(HistoricoNotificacao obj) throws IOException {
		try {
			System.out.println("111");

			Optional<Manutencao> objManutencao = manutencaoRepository.findById(obj.getManutencao().getId());
			System.out.println("222");
			Notificacao objNotificacao = notificacaoRepository.findByUsuario(obj.getUsuario().getCpf());
			System.out.println("objNotifica"+ objNotificacao.getChaveFirebase());
			String mensagemFinal = obj.getMensagem()+ " Bloco: " + objManutencao.get().getInventario().getCentroDeCusto().getBloco() + ", Sala: " + objManutencao.get().getInventario().getCentroDeCusto().getSala().getSala() +  ", Detalhes: "+ objManutencao.get().getInventario().getCentroDeCusto().getDetalhes();
			System.out.println("333");

			String stringFinal = "{\r\n    \"to\":\""
					+ objNotificacao.getChaveFirebase()
					+ "\",\r\n    \"notification\": {\"title\": \""
					+ obj.getTitulo()
					+ "\",\"body\": \""
					+ mensagemFinal
					+ "\"\"mutable_content\": true}}";
			System.out.println("444");
			OkHttpClient client = new OkHttpClient().newBuilder()
					  .build();
					MediaType mediaType = MediaType.parse("application/json");
					RequestBody body = RequestBody.create(mediaType, stringFinal);
					Request request = new Request.Builder()
					  .url("https://fcm.googleapis.com/fcm/send")
					  .method("POST", body)
					  .addHeader("Authorization", "key=AAAAbEwApNU:APA91bHgmRfA2qg1fQ_NA7NE7T-DRJsisg1cWLRYtS5pVJEE644Y6N0rruSIL4uWZ_2r6zLxmpX6j_WF6vsbCuvJfGgG96F0Ahmw78B_ITymgakSoZHGXq0o9C8PB89aTLj_YFSWHzxm")
					  .addHeader("Content-Type", "application/json")
					  .build();
					Response response = client.newCall(request).execute();
			obj.setMensagem(mensagemFinal);
			obj.setManutencao(obj.getManutencao());
			obj.setUsuario(obj.getUsuario());
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

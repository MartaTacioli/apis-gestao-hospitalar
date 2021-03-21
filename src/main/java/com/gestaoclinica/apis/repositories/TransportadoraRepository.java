package com.gestaoclinica.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.Regiao;
import com.gestaoclinica.apis.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	
	List<Usuario> findAllByAprovado(Integer aprovado);
	List<Usuario> findAllByRegiaoIn(List<Regiao> regioes);
	Usuario findByCnpj(Long cnpj);
	List<Usuario> findAllByRegiaoInAndAprovado(List<Regiao> regioes ,int aprovado);

}

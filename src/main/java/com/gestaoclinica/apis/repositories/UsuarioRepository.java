package com.gestaoclinica.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	

	List<Usuario> findAllByAprovado(Integer aprovado);
	Usuario findByCpf(Long cpf);

	List<Usuario> findAllByHierarquia(Long hierarquia);

}

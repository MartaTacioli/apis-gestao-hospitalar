package com.gestaoclinica.apis.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.Inventario;
import com.gestaoclinica.apis.entities.Manutencao;
import com.gestaoclinica.apis.entities.Usuario;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
	List<Manutencao> findAllByUsuarioExecutor (Long usuarioExecutor);
	List<Manutencao> findAllByInventario (Inventario inventario);
	
	List<Manutencao> findAllByUsuarioServico (Long usuarioServico);
	List<Manutencao> findAllByInventario_Usuario (Usuario usuario);
}

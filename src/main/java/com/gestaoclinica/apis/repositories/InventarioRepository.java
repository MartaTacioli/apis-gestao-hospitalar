package com.gestaoclinica.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.Inventario;
import com.gestaoclinica.apis.entities.Usuario;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
	void deleteById(Long id);
	List<Inventario> findAllByUsuario(Usuario usuario);
	
}

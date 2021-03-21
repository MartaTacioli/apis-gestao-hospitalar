package com.gestaoclinica.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
	void deleteById(Long id);
	
}

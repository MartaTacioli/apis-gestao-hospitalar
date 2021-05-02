package com.gestaoclinica.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {
	void deleteById(Long id);
	List<Sala> findAllByCnpj (Long cnpj);

}

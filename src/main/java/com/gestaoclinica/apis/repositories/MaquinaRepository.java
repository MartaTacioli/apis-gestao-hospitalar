package com.gestaoclinica.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.Equipamento;
import com.gestaoclinica.apis.entities.TaxaCepEscala;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
	void deleteById(Long id);
}

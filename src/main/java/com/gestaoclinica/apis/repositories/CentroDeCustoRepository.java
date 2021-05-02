package com.gestaoclinica.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.CentroDeCusto;

public interface CentroDeCustoRepository extends JpaRepository<CentroDeCusto, Long> {
	void deleteById(Long id);
	List<CentroDeCusto> findAllByCnpj(String cnpj);
}

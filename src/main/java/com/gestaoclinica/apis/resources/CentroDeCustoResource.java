package com.gestaoclinica.apis.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gestaoclinica.apis.entities.CentroDeCusto;
import com.gestaoclinica.apis.service.CentroDeCustoService;

@RestController
@RequestMapping (value = "/centro-de-custo")
public class CentroDeCustoResource {

	@Autowired
	private CentroDeCustoService service;

	@GetMapping(value = "/{cnpj}")
	public ResponseEntity<List<CentroDeCusto>> findAllByCnpj(@PathVariable String cnpj){
		System.out.println("Entrou aqui doidão" + cnpj);
		List<CentroDeCusto> obj = service.findAllByCnpj(cnpj);
		return ResponseEntity.ok().body(obj);
	}
	



	@PostMapping
	public ResponseEntity<CentroDeCusto> insert (@RequestBody CentroDeCusto obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PostMapping(value = "/deletar")
	public ResponseEntity<CentroDeCusto> delete (@RequestBody CentroDeCusto obj){
		obj = service.delete(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	

}

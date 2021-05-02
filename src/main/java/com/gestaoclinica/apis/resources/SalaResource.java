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

import com.gestaoclinica.apis.entities.Sala;
import com.gestaoclinica.apis.service.SalaService;

@RestController
@RequestMapping (value = "/sala")
public class SalaResource {

	@Autowired
	private SalaService service;

	@GetMapping(value = "/{cnpj}")
	public ResponseEntity<List<Sala>> findAllByCnpj(@PathVariable Long cnpj){
		List<Sala> obj = service.findAllByCnpj(cnpj);
		return ResponseEntity.ok().body(obj);
	}
	


	@PostMapping
	public ResponseEntity<Sala> insert (@RequestBody Sala obj){
		System.out.println("entrou 0");
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PostMapping(value = "/deletar")
	public ResponseEntity<Sala> delete (@RequestBody Sala obj){
		obj = service.delete(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	

}

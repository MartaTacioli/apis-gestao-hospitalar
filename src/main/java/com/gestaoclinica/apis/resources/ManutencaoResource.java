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

import com.gestaoclinica.apis.entities.Manutencao;
import com.gestaoclinica.apis.service.ManutencaoService;

@RestController
@RequestMapping (value = "/manutencao")
public class ManutencaoResource {
	
	@Autowired
	private ManutencaoService service;
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<Manutencao> findById(@PathVariable Long id){
		Manutencao obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/usuario/{cpf}")
	public ResponseEntity<List<Manutencao>> findAllByUsuario(@PathVariable Long cpf){
		List<Manutencao> obj = service.findAllByUsuario(cpf);
		return ResponseEntity.ok().body(obj);
	}


	@GetMapping(value = "/inventario/{id}")
	public ResponseEntity<List<Manutencao>> findAllByInventario(@PathVariable Long id){
		List<Manutencao> obj = service.findAllByInventario(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Manutencao> insert (@RequestBody Manutencao obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PostMapping(value = "/deletar")
	public ResponseEntity<Manutencao> delete (@RequestBody Manutencao obj){
		obj = service.delete(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	

}

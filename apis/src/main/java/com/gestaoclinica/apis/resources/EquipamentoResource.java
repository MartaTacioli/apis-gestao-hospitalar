package com.gestaoclinica.apis.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gestaoclinica.apis.entities.Inventario;
import com.gestaoclinica.apis.service.InventarioService;

@RestController
@RequestMapping (value = "/inventario")
public class InventarioResource {
	
	@Autowired
	private InventarioService service;
	
	@GetMapping
	public ResponseEntity<List<Inventario>> findAll(){
		List<Inventario> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Inventario> insert (@RequestBody Inventario obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PostMapping(value = "/deletar")
	public ResponseEntity<Inventario> delete (@RequestBody Inventario obj){
		obj = service.delete(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	

}

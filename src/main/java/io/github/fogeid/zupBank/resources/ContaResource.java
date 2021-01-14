package io.github.fogeid.zupBank.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.fogeid.zupBank.entities.Conta;
import io.github.fogeid.zupBank.services.ContaService;

@RestController
@RequestMapping(value = "/conta")
public class ContaResource {
	
	@Autowired
	private ContaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Conta> findById(@PathVariable Long id) {
		Conta obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Conta> insert(@RequestBody Conta obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);		
	}
}
package dev.theduardomaciel.javadesignpatterns.spring.controller;

import dev.theduardomaciel.javadesignpatterns.spring.model.Client;
import dev.theduardomaciel.javadesignpatterns.spring.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 *
 * @author falvojr
 */
@RestController
@RequestMapping("clients")
public class ClientController {
	private final ClientService clientService;
	
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Client>> searchAll() {
		return ResponseEntity.ok(clientService.searchAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> searchById(@PathVariable Long id) {
		return ResponseEntity.ok(clientService.searchById(id));
	}
	
	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody Client client) {
		Client insertedClient = clientService.insert(client);
		// Obtemos o cliente inserido para retornar o ID gerado
		
		return ResponseEntity.ok(insertedClient);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
		clientService.update(id, client);
		return ResponseEntity.ok(client);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clientService.delete(id);
		return ResponseEntity.ok().build();
	}
}
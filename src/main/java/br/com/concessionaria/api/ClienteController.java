package br.com.concessionaria.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.concessionaria.model.Carro;
import br.com.concessionaria.model.Cliente;
import br.com.concessionaria.repository.ClienteRepository;
import br.com.concessionaria.service.ClienteService;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listaClientes() {
		List<Cliente> clientes = new ArrayList();
		clientes = clienteService.buscarClientes();
		return ResponseEntity.ok().body(clientes);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> getCarroById(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteService.findById(id);
		return ResponseEntity.ok().body(cliente);
	}
	
	@PostMapping("/cadastro")
	public ResponseEntity<?> cadastraCliente(@RequestBody Cliente cliente) {
		clienteService.createCliente(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<?> deleteClienteById(@PathVariable Long id) {
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCliente(@RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente clienteUpdate = cliente;
		clienteUpdate.setId(id);
		clienteService.update(clienteUpdate);
		
		return ResponseEntity.noContent().build();
	}
	
}

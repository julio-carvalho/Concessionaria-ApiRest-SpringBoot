package br.com.concessionaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.concessionaria.model.Carro;
import br.com.concessionaria.model.Cliente;
import br.com.concessionaria.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente createCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> buscarClientes() {
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}
	
	public void delete(Long id) {
		clienteRepository.delete(this.getCliente(id));
	}
	
	public Cliente getCliente(Long id) {
		return clienteRepository.getById(id);
	}
	
	public void update (Cliente cliente) {
		Optional<Cliente> clienteUpdate = clienteRepository.findById(cliente.getId());
		this.atualizarDados(clienteUpdate, cliente);
		clienteRepository.save(clienteUpdate.get());
	}
	
	private void atualizarDados(Optional<Cliente> clienteUpdate, Cliente cliente) {
		clienteUpdate.get().setNome(cliente.getNome());
		clienteUpdate.get().setCpf(cliente.getCpf());
		clienteUpdate.get().setEmail(cliente.getEmail());
		clienteUpdate.get().setTelefone(cliente.getTelefone());
	}
}

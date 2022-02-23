package br.com.concessionaria.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.concessionaria.dto.ClienteDTO;
import br.com.concessionaria.dto.VendaDTO;
import br.com.concessionaria.model.Carro;
import br.com.concessionaria.model.Cliente;
import br.com.concessionaria.repository.CarroRepository;
import br.com.concessionaria.repository.ClienteRepository;
import br.com.concessionaria.service.CarroService;
import br.com.concessionaria.service.ClienteService;

@RestController
@RequestMapping("api/carro")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	@Autowired
	private CarroRepository carroRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Carro>> listaCarros() {
		List<Carro> carros = new ArrayList();
		carros = carroService.buscarCarros();
		return ResponseEntity.ok().body(carros);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Carro>> getCarroById(@PathVariable Long id) {
		Optional<Carro> carro = carroService.findById(id);
		return ResponseEntity.ok().body(carro);
	}
	
	@PostMapping("/cadastro")
	public ResponseEntity<?> cadastraCarro(@RequestBody Carro carro) {
		carroService.createCarro(carro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(carro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<?> deleteCarroById(@PathVariable Long id) {
		carroService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCarro(@RequestBody Carro carro, @PathVariable Long id) {
		Carro carroUpdate = carro;
		carroUpdate.setId(id);
		carroService.update(carroUpdate);
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/venda/{id}")
	public ResponseEntity<?> vendaCarro(@PathVariable("id") long id, @RequestBody ClienteDTO clienteDTO) {
		Optional<Carro> buscaCarroId = carroRepository.findById(id);
		
		if(!buscaCarroId.get().isDisponivel()){
			return ResponseEntity.notFound().build();
		}
		
		Cliente cli = clienteRepository.findByCpf(clienteDTO.getCpf());
		
		if(cli == null) {
			return ResponseEntity.notFound().build();
		}
		
		if(cli.isPrimeira()) {
			double valor = buscaCarroId.get().getValor();
			double valorFinal = valor * (1 -(1 / 100));
			buscaCarroId.get().setValor(valorFinal);
		}
		
		buscaCarroId.get().setDisponivel(false);
		carroService.salvaCarro(buscaCarroId.get());
		
		cli.setPrimeira(false);
		clienteService.salvaCliente(cli);
		
		return ResponseEntity.ok().body(buscaCarroId.get());
	}
	
	@GetMapping("/totalvendas")
	public ResponseEntity<?> totalVendas(){
		VendaDTO totalVendas = new VendaDTO(carroRepository.valor());
		return ResponseEntity.ok().body(totalVendas);
	}
}

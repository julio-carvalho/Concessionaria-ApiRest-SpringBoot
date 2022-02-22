package br.com.concessionaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.concessionaria.model.Carro;
import br.com.concessionaria.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	
	public Carro createCarro(Carro carro) {
		return carroRepository.save(carro);
	}
	
	public List<Carro> buscarCarros() {
		return carroRepository.findAll();
	}
	
	public Optional<Carro> findById(Long id) {
		return carroRepository.findById(id);
	}
	
	public void delete(Long id) {
		carroRepository.delete(this.getCarro(id));
	}
	
	public Carro getCarro(Long id) {
		return carroRepository.getById(id);
	}
	
	public void update (Carro carro) {
		Optional<Carro> carroUpdate = carroRepository.findById(carro.getId());
		this.atualizarDados(carroUpdate, carro);
		carroRepository.save(carroUpdate.get());
	}
	
	private void atualizarDados(Optional<Carro> carroUpdate, Carro carro) {
		carroUpdate.get().setCategoria(carro.getCategoria());
		carroUpdate.get().setValor(carro.getValor());
		carroUpdate.get().setAno(carro.getAno());
		carroUpdate.get().setModelo(carro.getModelo());
		carroUpdate.get().setMarca(carro.getMarca());
	}
}

package br.com.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.concessionaria.model.Carro;


@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
	
}

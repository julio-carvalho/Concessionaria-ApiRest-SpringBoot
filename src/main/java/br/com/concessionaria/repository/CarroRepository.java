package br.com.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.concessionaria.model.Carro;


@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
	
	//soma todos os carros que foram vendidos, que estiverem com disponivel = false
	@Query(value = "Select sum(c.valor) FROM Carro c WHERE c.disponivel = 0")
	double valor();
}

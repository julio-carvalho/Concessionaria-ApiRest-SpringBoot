package br.com.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.concessionaria.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	@Query("Select c from Cliente c where c.cpf = ?1")
	Cliente findByCpf(@Param("cpf") String cpf);
}

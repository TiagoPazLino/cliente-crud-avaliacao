package br.com.tokiomarine.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.tokiomarine.damain.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
	@Query("select e from Endereco e inner join e.cliente c where c.id = :ClienteId")
	Iterable<Endereco> findAllByClienteId(Long ClienteId);
}

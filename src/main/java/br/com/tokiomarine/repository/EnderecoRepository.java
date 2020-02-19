package br.com.tokiomarine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.tokiomarine.damain.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

}

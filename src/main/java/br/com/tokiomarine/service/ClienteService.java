package br.com.tokiomarine.service;

import br.com.tokiomarine.damain.Cliente;

public interface ClienteService {
	Iterable<Cliente> findAll();

	Cliente save(Cliente cliente);

	String delete(long id);
}

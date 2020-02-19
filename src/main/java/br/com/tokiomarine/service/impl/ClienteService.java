package br.com.tokiomarine.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.damain.Cliente;
import br.com.tokiomarine.repository.ClienteRepository;
import br.com.tokiomarine.service.CrudService;

@Service
public class ClienteService implements CrudService<Cliente, Long> {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Iterable<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente findById(Long id) {
		Optional<Cliente> baseCliente = clienteRepository.findById(id);
		return baseCliente.isPresent() ? baseCliente.get() : null;
	}

	@Override
	public Cliente save(Cliente paramCliente) {
		return clienteRepository.save(paramCliente);
	}

	@Override
	public String delete(long id) {
		clienteRepository.deleteById(id);
		return "OK";
	}

}

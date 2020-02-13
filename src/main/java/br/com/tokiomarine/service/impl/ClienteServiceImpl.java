package br.com.tokiomarine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.damain.Cliente;
import br.com.tokiomarine.repository.ClienteRepository;
import br.com.tokiomarine.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Iterable<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public String delete(long id) {
		clienteRepository.deleteById(id);
		return "OK";
	}

}

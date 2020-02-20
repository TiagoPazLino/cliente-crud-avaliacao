package br.com.tokiomarine.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.damain.Cliente;
import br.com.tokiomarine.damain.Endereco;
import br.com.tokiomarine.repository.ClienteRepository;
import br.com.tokiomarine.service.CrudService;

@Service
public class ClienteService implements CrudService<Cliente, Long> {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoService enderecoService;

	@Override
	public Iterable<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public List<Cliente> findPage(int page, int size) {
		PagedListHolder<Cliente> pagina = new PagedListHolder<Cliente>((List<Cliente>) clienteRepository.findAll());
		pagina.setPageSize(size);
		pagina.setPage(page);
		return pagina.getPageList();
	}

	@Override
	public Cliente findById(Long id) {
		Optional<Cliente> baseCliente = clienteRepository.findById(id);
		if (baseCliente.isPresent()) {
			return baseCliente.get();
		}
		return null;
	}

	@Override
	public Cliente save(Cliente paramCliente) {
		List<Endereco> enderecosCliente = paramCliente.getEndereco();
		paramCliente.setEndereco(new ArrayList<Endereco>());
		Cliente clienteSalvo = clienteRepository.save(paramCliente);
		for (Endereco endereco : enderecosCliente) {
			endereco.setCliente(clienteSalvo);
			enderecoService.save(endereco);
		}
		return findById(clienteSalvo.getId());

	}

	@Override
	public String delete(long id) {
		clienteRepository.deleteById(id);
		return "OK";
	}

}

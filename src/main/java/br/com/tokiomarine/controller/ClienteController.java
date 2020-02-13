package br.com.tokiomarine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.damain.Cliente;
import br.com.tokiomarine.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public Iterable<Cliente> listarClientes() {
		return clienteService.findAll();
	}
	
	@PostMapping
	@PutMapping
	public Cliente salvarCliente(@RequestBody Cliente cliente){
		return clienteService.save(cliente);
	}
	
	@DeleteMapping
	public Cliente deletarCliente(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}

}

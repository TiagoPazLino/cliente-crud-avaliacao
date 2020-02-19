package br.com.tokiomarine.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.damain.Cliente;
import br.com.tokiomarine.service.impl.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public Iterable<Cliente> listarClientes() {
		return clienteService.findAll();
	}
	
	@GetMapping("/{idCliente}")
	public Iterable<Cliente> listarClientesPorId(@PathParam("idCliente") int idCliente) {
		return clienteService.findAll();
	}

	@PostMapping
	@PutMapping
	public Cliente salvarCliente(@RequestBody Cliente cliente){
		return clienteService.save(cliente);
	}
	
	@DeleteMapping("/{idCliente}")
	public String deletarCliente(@PathParam("idCliente") int idCliente) {
		return clienteService.delete(idCliente);
	}

}

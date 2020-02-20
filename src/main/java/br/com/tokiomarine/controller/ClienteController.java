package br.com.tokiomarine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.damain.Cliente;
import br.com.tokiomarine.exception.NotFoundException;
import br.com.tokiomarine.service.impl.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> listarPaginaClientes(@RequestParam("page") int page,
			@RequestParam("size") int size) {
		return clienteService.findPage(page, size);
	}
	
	@GetMapping("/{idCliente}")
	public Cliente listarClientesPorId(@PathVariable("idCliente") Long idCliente) {
		Cliente cliente = clienteService.findById(idCliente);
		if (cliente == null) {
			throw new NotFoundException();
		}
		return cliente;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}

	@PutMapping
	public Cliente atualizarCliente(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}
	
	@DeleteMapping("/{idCliente}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String deletarCliente(@PathVariable("idCliente") Long idCliente) {
		return clienteService.delete(idCliente);
	}

}

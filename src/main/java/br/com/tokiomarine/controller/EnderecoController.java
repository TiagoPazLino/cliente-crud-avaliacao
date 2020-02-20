package br.com.tokiomarine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.damain.Endereco;
import br.com.tokiomarine.exception.EmptyException;
import br.com.tokiomarine.service.impl.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping
	public Iterable<Endereco> listarEnderecos() {
		return enderecoService.findAll();
	}
	
	@GetMapping("/{idCliente}")
	public Iterable<Endereco> listarEnderecosPorCliente(@PathVariable("idCliente") Long idCliente) {
		Iterable<Endereco> enderecos = enderecoService.findByClienteId(idCliente);
		if (enderecos == null) {
			throw new EmptyException();
		}
		return enderecos;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco salvarEndereco(@RequestBody Endereco Endereco) {
		return enderecoService.save(Endereco);
	}

	@PutMapping
	public Endereco atualizarEndereco(@RequestBody Endereco Endereco) {
		return enderecoService.save(Endereco);
	}
	
	@DeleteMapping("/{idEndereco}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String deletarEndereco(@PathVariable("idEndereco") Long idEndereco) {
		return enderecoService.delete(idEndereco);
	}

}

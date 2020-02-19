package br.com.tokiomarine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.damain.Endereco;
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
	
	@PostMapping
	@PutMapping
	public Endereco salvarEndereco(@RequestBody Endereco Endereco) {
		return enderecoService.save(Endereco);
	}
	
	@DeleteMapping
	public Endereco deletarEndereco(@RequestBody Endereco Endereco) {
		return enderecoService.save(Endereco);
	}

}

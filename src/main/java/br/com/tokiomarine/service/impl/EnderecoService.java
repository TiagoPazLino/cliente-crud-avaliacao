package br.com.tokiomarine.service.impl;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.tokiomarine.damain.Endereco;
import br.com.tokiomarine.repository.EnderecoRepository;
import br.com.tokiomarine.service.CrudService;
import br.com.tokiomarine.utils.Constantes;

@Service
public class EnderecoService implements CrudService<Endereco, Long> {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public Iterable<Endereco> findAll() {
		return enderecoRepository.findAll();
	}

	public Iterable<Endereco> findByClienteId(Long idCliente) {
		Iterable<Endereco> enderecos = enderecoRepository.findAllByClienteId(idCliente);
		if (enderecos.spliterator().getExactSizeIfKnown() != 0) {
			return enderecos;
		}
		return null;
	}

	@Override
	public Endereco findById(Long id) {
		Optional<Endereco> baseEndereco = enderecoRepository.findById(id);
		return baseEndereco.isPresent() ? baseEndereco.get() : null;
	}

	@Override
	public Endereco save(Endereco paramEndereco) {
		RestTemplate rest = new RestTemplate();
		Endereco apiEndereco = null;
		try {
			URI uri = urlCepBuilder(paramEndereco.getCep(), Constantes.VIA_CEP_RETURN_JSON);
			apiEndereco = rest.getForObject(uri, Endereco.class);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		apiEndereco.setCliente(paramEndereco.getCliente());
		apiEndereco.setComplemento(paramEndereco.getComplemento());
		apiEndereco.setNumero(paramEndereco.getNumero());
		return enderecoRepository.save(apiEndereco);
	}

	@Override
	public String delete(long id) {
		enderecoRepository.deleteById(id);
		return "OK";
	}

	private URI urlCepBuilder(String cep, String apiReturnType) throws MalformedURLException {
		return URI.create(Constantes.VIA_CEP_URL + cep + apiReturnType);
	}


}

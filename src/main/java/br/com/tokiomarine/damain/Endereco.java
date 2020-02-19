package br.com.tokiomarine.damain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JsonProperty(access=Access.WRITE_ONLY)
	private Cliente cliente;

	@Column
	@NonNull
	// @Pattern(regexp = "([(0-9)]{8})")
	private String cep;
	
	@Column
	private String logradouro;
	
	@Column
	private int numero;

	@Column
	private String complemento = "";

	@Column
	private String bairro;
	
	@Column
	private String localidade;
	
	@Column
	private String uf;

}

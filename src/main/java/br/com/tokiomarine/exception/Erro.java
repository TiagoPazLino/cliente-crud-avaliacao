package br.com.tokiomarine.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Erro {
	private HttpStatus status;
	private String mensagem;
}

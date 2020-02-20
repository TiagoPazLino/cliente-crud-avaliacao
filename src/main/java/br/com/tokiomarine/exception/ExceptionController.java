package br.com.tokiomarine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.tokiomarine.utils.Constantes;

@ControllerAdvice
public class ExceptionController {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public Erro notFoundException() {
		return new Erro(HttpStatus.NOT_FOUND, Constantes.NOT_FOUND_MESSAGE);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ExceptionHandler(EmptyException.class)
	public Erro emptyException() {
		return new Erro(HttpStatus.NO_CONTENT, Constantes.NO_CONTENT_MESSAGE);
	}

}

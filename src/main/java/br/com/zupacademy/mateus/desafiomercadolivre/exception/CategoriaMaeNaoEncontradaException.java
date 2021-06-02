package br.com.zupacademy.mateus.desafiomercadolivre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CategoriaMaeNaoEncontradaException extends Throwable{

	private static final long serialVersionUID = 1L;

	public CategoriaMaeNaoEncontradaException() { super("CATEGORIA MÃE NÂO ENCONTRADA");}

}

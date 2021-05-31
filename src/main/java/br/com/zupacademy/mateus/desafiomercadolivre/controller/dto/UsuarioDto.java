package br.com.zupacademy.mateus.desafiomercadolivre.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.mateus.desafiomercadolivre.model.Usuario;

public class UsuarioDto {
	
	@NotBlank
	private String cadastro;
	@NotBlank @Size(min=6)
	private String senha;
	
	public UsuarioDto(@NotBlank String cadastro, @NotBlank String senha) {
		this.cadastro = cadastro;
		this.senha = senha;
	}

	public Usuario toModel() {
		return new Usuario(cadastro, senha);
	}
	
	
}

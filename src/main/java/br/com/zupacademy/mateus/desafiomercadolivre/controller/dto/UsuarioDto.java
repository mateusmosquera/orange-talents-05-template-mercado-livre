package br.com.zupacademy.mateus.desafiomercadolivre.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.mateus.desafiomercadolivre.model.SenhaLimpa;
import br.com.zupacademy.mateus.desafiomercadolivre.model.Usuario;

public class UsuarioDto {
	
	@NotBlank @Email
	private String email;
	@NotBlank @Size(min=6)
	private String senha;
	
	public UsuarioDto(@NotBlank String email, @NotBlank String senha) {
		this.email = email;
		this.senha = senha;
	}

	public Usuario toModel() {
		return new Usuario(email, new SenhaLimpa(senha));
	}
	
	
}

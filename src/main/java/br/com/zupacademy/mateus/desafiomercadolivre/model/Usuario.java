package br.com.zupacademy.mateus.desafiomercadolivre.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String cadastro;
	@NotBlank
	private String senha;
	@NotNull
	private Date cadastroInstante = Date.valueOf(LocalDate.now());
	
	@Deprecated
	public Usuario() {
		
	}
	
	public Usuario(@NotBlank String cadastro, @NotBlank String senha) {
		this.cadastro = cadastro;
		this.senha = new BCryptPasswordEncoder().encode(senha);
	}
	
}

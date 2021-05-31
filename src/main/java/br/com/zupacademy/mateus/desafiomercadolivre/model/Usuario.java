package br.com.zupacademy.mateus.desafiomercadolivre.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Entity
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank @Email
	private String email;
	@NotBlank
	private String senha;
	@NotNull
	@PastOrPresent
	private LocalDateTime cadastroInstante;
	
	@Deprecated
	public Usuario() {
		
	}
	
	public Usuario(@NotBlank String email, @Valid @NotNull SenhaLimpa senhaLimpa) {
		Assert.isTrue(StringUtils.hasLength(email),"email não pode ser em branco");
		Assert.notNull(senhaLimpa,"o objeto do tipo senha limpa nao pode ser nulo");
		this.cadastroInstante = LocalDateTime.now();
		this.email = email;
		this.senha =  senhaLimpa.hash();
	}
	
}

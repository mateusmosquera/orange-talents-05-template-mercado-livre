package br.com.zupacademy.mateus.desafiomercadolivre.controller.dto;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.mateus.desafiomercadolivre.controller.annotations.UniqueValue;
import br.com.zupacademy.mateus.desafiomercadolivre.exception.CategoriaMaeNaoEncontradaException;
import br.com.zupacademy.mateus.desafiomercadolivre.model.Categoria;
import br.com.zupacademy.mateus.desafiomercadolivre.repository.CategoriaRepository;

public class CategoriaDto {

	@NotBlank @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Nome da Categoria já cadastrado")
	private String nome;
	
	private Long idCartegoriaMae;
	
	public CategoriaDto(@NotBlank String nome) {
		this.nome = nome;
	}

	public CategoriaDto(@NotBlank String nome, Long idCartegoriaMae) {
		this.nome = nome;
		this.idCartegoriaMae = idCartegoriaMae;
	}

	public Categoria toModel(CategoriaRepository categoriaRepository) throws CategoriaMaeNaoEncontradaException {
		if(idCartegoriaMae==null) {
			return  new Categoria(this.nome);
		}
		Optional<Categoria> categoriaMae = categoriaRepository.findById(idCartegoriaMae);
		if(categoriaMae.isEmpty()) {
			throw new CategoriaMaeNaoEncontradaException();
		}
		
		return new Categoria(this.nome,categoriaMae.get());
	}
	
}

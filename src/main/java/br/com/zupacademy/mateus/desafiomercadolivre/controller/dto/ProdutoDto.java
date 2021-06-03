package br.com.zupacademy.mateus.desafiomercadolivre.controller.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.zupacademy.mateus.desafiomercadolivre.controller.annotations.ExistsId;
import br.com.zupacademy.mateus.desafiomercadolivre.model.Categoria;
import br.com.zupacademy.mateus.desafiomercadolivre.model.Produto;
import br.com.zupacademy.mateus.desafiomercadolivre.repository.CategoriaRepository;

public class ProdutoDto {
	
	@NotBlank
	private String nome;
	
	@NotNull
	private BigDecimal valor;
	
	@NotNull
	@Positive
	private Long quantidade;
	
	@Size(min = 3)
	@NotNull
	@Valid
	private List<CaracteristicaProdutoDto> caracteristicas = new ArrayList<>();
	
	@NotBlank @Size(max=1000)
	private String descricao;
	
	@NotNull
	@ExistsId(domainClass = Categoria.class, fieldName = "id", message= "Id da categoria não existe")
	private Long idCategoria;
	
	public ProdutoDto(@NotBlank String nome, @NotNull BigDecimal valor, @NotNull @Positive Long quantidade,
			@Size(min = 3) @Valid List<CaracteristicaProdutoDto> caracteristicas,
			@NotBlank @Size(max = 1000) String descricao, @NotNull Long idCategoria) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
		this.caracteristicas.addAll(caracteristicas);	
		this.descricao = descricao;
		this.idCategoria = idCategoria;
	}

	public Produto toModel(CategoriaRepository categoriaRepository) {
		Optional<Categoria> categoria = categoriaRepository.findById(this.idCategoria);
		return new Produto(nome, valor, quantidade, caracteristicas, descricao, categoria.get());
	}
	
}

package br.com.zupacademy.mateus.desafiomercadolivre.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.zupacademy.mateus.desafiomercadolivre.controller.dto.CaracteristicaProdutoDto;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotNull
	private BigDecimal valor;
	
	@NotNull
	@Positive
	private Long quantidade;
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.PERSIST)
	@Size(min=3)
	@NotNull
	private Set<CaracteristicaProduto> caracteristicas = new HashSet<>();
	
	@NotBlank @Size(max=1000)
	private String descricao;
	
	@ManyToOne
	@NotNull
	private Categoria categoria;
	
	@NotNull
	@PastOrPresent
	private LocalDateTime cadastroInstante;

	@Deprecated
	public Produto() {
		
	}
	
	public Produto(@NotBlank String nome, @NotNull BigDecimal valor, @NotNull @Positive Long quantidade,
			@Size(min = 3) @Valid Collection<CaracteristicaProdutoDto> caracteristicas, @NotBlank @Size(max = 1000) String descricao,
			Categoria categoria) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
		this.caracteristicas.addAll(caracteristicas.stream()
				.map(caracteristica-> caracteristica.toModel(this))
				.collect(Collectors.toSet()));
		this.descricao = descricao;
		this.categoria = categoria;
		this.cadastroInstante = LocalDateTime.now();
	}
	
	
}

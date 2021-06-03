package br.com.zupacademy.mateus.desafiomercadolivre.controller.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.mateus.desafiomercadolivre.model.CaracteristicaProduto;
import br.com.zupacademy.mateus.desafiomercadolivre.model.Produto;

public class CaracteristicaProdutoDto {

	@NotBlank
	private String nome;
	@NotBlank
	private String descricao;
	
	public CaracteristicaProdutoDto(@NotBlank String nome, @NotBlank String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public CaracteristicaProduto toModel(@NotNull @Valid Produto produto) {
		return new CaracteristicaProduto(nome,descricao,produto);
	}
	
}

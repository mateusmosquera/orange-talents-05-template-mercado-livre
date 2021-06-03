package br.com.zupacademy.mateus.desafiomercadolivre.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateus.desafiomercadolivre.controller.dto.ProdutoDto;
import br.com.zupacademy.mateus.desafiomercadolivre.model.Produto;
import br.com.zupacademy.mateus.desafiomercadolivre.repository.CategoriaRepository;
import br.com.zupacademy.mateus.desafiomercadolivre.repository.ProdutoRepository;

@RestController
@RequestMapping(value="/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping 
	public ResponseEntity<?> cadastrar(@RequestBody @Valid ProdutoDto produtoDto ){
		
		Produto produto = produtoDto.toModel(categoriaRepository);
		
		produtoRepository.save(produto);
		
		return ResponseEntity.ok().build();
	}

}

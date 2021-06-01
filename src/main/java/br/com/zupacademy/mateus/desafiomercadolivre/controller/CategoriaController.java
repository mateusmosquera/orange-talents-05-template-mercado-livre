package br.com.zupacademy.mateus.desafiomercadolivre.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateus.desafiomercadolivre.controller.dto.CategoriaDto;
import br.com.zupacademy.mateus.desafiomercadolivre.exception.CategoriaMaeNaoEncontradaException;
import br.com.zupacademy.mateus.desafiomercadolivre.model.Categoria;
import br.com.zupacademy.mateus.desafiomercadolivre.repository.CategoriaRepository;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaDto categoriaDto) throws CategoriaMaeNaoEncontradaException{
		
		Categoria categoria = categoriaDto.toModel(categoriaRepository);
		
		categoriaRepository.save(categoria);
		
		return ResponseEntity.ok().build();
	}
	
}

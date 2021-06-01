package br.com.zupacademy.mateus.desafiomercadolivre.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.mateus.desafiomercadolivre.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria,Long>{
	
	Optional<Categoria> findById(Long id);
	
}

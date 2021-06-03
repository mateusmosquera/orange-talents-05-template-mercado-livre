package br.com.zupacademy.mateus.desafiomercadolivre.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.mateus.desafiomercadolivre.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto,Long>{

}

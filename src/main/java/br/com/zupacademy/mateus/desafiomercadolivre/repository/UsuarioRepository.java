package br.com.zupacademy.mateus.desafiomercadolivre.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.mateus.desafiomercadolivre.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario,Long>{

}

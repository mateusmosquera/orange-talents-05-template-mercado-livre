package br.com.zupacademy.mateus.desafiomercadolivre.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateus.desafiomercadolivre.controller.dto.UsuarioDto;
import br.com.zupacademy.mateus.desafiomercadolivre.model.Usuario;
import br.com.zupacademy.mateus.desafiomercadolivre.repository.UsuarioRepository;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar (@RequestBody @Valid UsuarioDto userDto){
		
		Usuario newUser = userDto.toModel();
		
		userRepository.save(newUser);
		
		return ResponseEntity.ok().build();
	}
}

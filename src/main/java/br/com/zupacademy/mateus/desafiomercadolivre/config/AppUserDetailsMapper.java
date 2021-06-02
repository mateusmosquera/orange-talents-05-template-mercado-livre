package br.com.zupacademy.mateus.desafiomercadolivre.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.zupacademy.mateus.desafiomercadolivre.config.security.UserDetailsMapper;
import br.com.zupacademy.mateus.desafiomercadolivre.config.security.UsuarioLogado;
import br.com.zupacademy.mateus.desafiomercadolivre.model.Usuario;

@Configuration
public class AppUserDetailsMapper implements UserDetailsMapper{

	@Override
	public UserDetails map(Object shouldBeASystemUser) {						
		return new UsuarioLogado((Usuario)shouldBeASystemUser);
	}

}

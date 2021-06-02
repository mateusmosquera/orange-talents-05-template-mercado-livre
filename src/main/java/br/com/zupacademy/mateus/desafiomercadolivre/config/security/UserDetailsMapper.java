package br.com.zupacademy.mateus.desafiomercadolivre.config.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsMapper {

	UserDetails map(Object shouldBeASystemUser);
}
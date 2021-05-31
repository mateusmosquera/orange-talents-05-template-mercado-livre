package br.com.zupacademy.mateus.desafiomercadolivre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class DesafioMercadoLivreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioMercadoLivreApplication.class, args);
	}

}

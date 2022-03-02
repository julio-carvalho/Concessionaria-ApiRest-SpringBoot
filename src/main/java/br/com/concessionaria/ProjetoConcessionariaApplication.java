package br.com.concessionaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class ProjetoConcessionariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoConcessionariaApplication.class, args);
	}

}

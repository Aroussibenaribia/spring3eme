package com.aroussi.joueurs;

import com.aroussi.joueurs.entities.Joueur;
import com.aroussi.joueurs.entities.Label;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class JoueursApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(JoueursApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Joueur.class, Label.class);
	}

}

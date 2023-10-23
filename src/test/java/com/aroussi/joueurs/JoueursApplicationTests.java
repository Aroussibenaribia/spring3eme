package com.aroussi.joueurs;

import com.aroussi.joueurs.entities.Joueur;
import com.aroussi.joueurs.entities.Label;
import com.aroussi.joueurs.repos.JoueurRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class JoueursApplicationTests {
	@Autowired
	private JoueurRepository joueurRepository;

	@Test
	public void testCreateAlbum() {
		Joueur joueur = new Joueur("All Eyes On Me", "Tupac Shakur", "Rap", new Date());
		joueurRepository.save(joueur);
	}

	@Test
	public void testFindAlbum() {
		Joueur joueur = joueurRepository.findById(1L).get();
		System.out.println(joueur);
	}

	@Test
	public void testUpdateAlbum() {
		Joueur joueur = joueurRepository.findById(1L).get();
		joueur.setGenre("Progressive Rock");
		joueurRepository.save(joueur);
	}

	@Test
	public void testDeleteAlbum() {
		joueurRepository.deleteById(1L);
	}

	@Test
	public void testListAlbums() {
		Iterable<Joueur> albums = joueurRepository.findAll();
		for (Joueur joueur : albums) {
			System.out.println(joueur);
		}
	}

	@Test
	public void testFindByTitle() {
		List<Joueur> joueurs = joueurRepository.findByTitle("The Life Of Pablo");
		for (Joueur joueur : joueurs) {
			System.out.println(joueur);
		}
	}

	@Test
	public void testFindByTitleContains() {
		List<Joueur> joueurs = joueurRepository.findByTitleContains("Pablo");
		for (Joueur joueur : joueurs) {
			System.out.println(joueur);
		}
	}

	@Test
	public void testFindByGenre() {
		List<Joueur> joueurs = joueurRepository.findByGenre("Hip Hop");
		for (Joueur joueur : joueurs) {
			System.out.println(joueur);
		}
	}

	@Test
	public void testFindByLabel() {
		Label label = new Label();
		label.setIdLabel(1L);

		List<Joueur> joueurs = joueurRepository.findByLabel(label);
		for (Joueur joueur : joueurs) {
			System.out.println(joueur);
		}
	}

	@Test
	public void testFindByLabelIdLabel() {
		List<Joueur> joueurs = joueurRepository.findByLabelIdLabel(1L);
		for (Joueur joueur : joueurs) {
			System.out.println(joueur);
		}
	}

	@Test
	public void testFindByOrderByTitleAsc() {
		List<Joueur> joueurs = joueurRepository.findByOrderByTitleAsc();
		for (Joueur joueur : joueurs) {
			System.out.println(joueur);
		}
	}

	@Test
	public void testSortByTitleAndGenre() {
		List<Joueur> joueurs = joueurRepository.sortByTitleAndGenre();
		for (Joueur joueur : joueurs) {
			System.out.println(joueur);
		}
	}
}

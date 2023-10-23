package com.aroussi.joueurs.repos;

import com.aroussi.joueurs.entities.Joueur;
import com.aroussi.joueurs.entities.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource (path = "rest")
public interface JoueurRepository extends JpaRepository<Joueur, Long> {
    List<Joueur> findByTitle(String title);
    List<Joueur> findByTitleContains(String title);

    @Query("select a from Joueur a where a.genre like %?1")
    List<Joueur> findByGenre(String genre);

    @Query("select a from Joueur a where a.label = ?1")
    List<Joueur> findByLabel(Label label);

    List<Joueur> findByLabelIdLabel(Long id);

    List<Joueur> findByOrderByTitleAsc();

    @Query ("select a from Joueur a order by a.title asc, a.genre desc")
    List<Joueur> sortByTitleAndGenre();

}

package com.aroussi.joueurs.service;

import com.aroussi.joueurs.dto.AlbumDTO;
import com.aroussi.joueurs.entities.Joueur;
import com.aroussi.joueurs.entities.Label;

import java.util.List;

public interface JoueurService {
    AlbumDTO saveAlbum(AlbumDTO a);
    AlbumDTO updateAlbum(AlbumDTO a);
    void deleteAlbum(Joueur a);
    void deleteAlbumById(Long id);
    AlbumDTO getAlbum(Long id);
    List<AlbumDTO> getAllAlbums();
    List<Joueur> findByTitle(String title);
    List<Joueur> findByTitleContains(String title);
    List<Joueur> findByGenre(String genre);
    List<Joueur> findByLabel(Label label);
    List<Joueur> findByLabelIdLabel(Long id);
    List<Joueur> findByOrderByTitleAsc();
    List<Joueur> sortByTitleAndGenre();
    AlbumDTO convertEntityToDTO(Joueur a);
    Joueur convertDTOToEntity(AlbumDTO a);
}

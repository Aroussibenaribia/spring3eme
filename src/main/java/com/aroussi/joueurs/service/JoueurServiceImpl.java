package com.aroussi.joueurs.service;

import com.aroussi.joueurs.dto.AlbumDTO;
import com.aroussi.joueurs.entities.Joueur;
import com.aroussi.joueurs.entities.Label;
import com.aroussi.joueurs.repos.JoueurRepository;
import com.aroussi.joueurs.repos.ImageRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoueurServiceImpl implements JoueurService {
    @Autowired
    JoueurRepository joueurRepository;
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public AlbumDTO saveAlbum(AlbumDTO a) {
        return convertEntityToDTO(joueurRepository.save(convertDTOToEntity(a)));
    }

    @Override
    public AlbumDTO updateAlbum(AlbumDTO a) {
        Long oldImageId = this.getAlbum(a.getIdAlbum()).getImage().getIdImage();
        Long newImageId = a.getImage().getIdImage();
        Joueur joueurUpdated = joueurRepository.save(convertDTOToEntity(a));
        if (oldImageId != newImageId) {
            imageRepository.deleteById(oldImageId);
        }
        return convertEntityToDTO(joueurUpdated);
    }

    @Override
    public void deleteAlbum(Joueur a) {
        joueurRepository.delete(a);
    }

    @Override
    public void deleteAlbumById(Long id) {
        joueurRepository.deleteById(id);
    }

    @Override
    public AlbumDTO getAlbum(Long id) {
        return convertEntityToDTO(joueurRepository.findById(id).get());
    }

    @Override
    public List<AlbumDTO> getAllAlbums() {
        return joueurRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    // Methods From AlbumRepository

    @Override
    public List<Joueur> findByTitle(String title) {
        return joueurRepository.findByTitle(title);
    }

    @Override
    public List<Joueur> findByTitleContains(String title) {
        return joueurRepository.findByTitleContains(title);
    }

    @Override
    public List<Joueur> findByGenre(String genre) {
        return joueurRepository.findByGenre(genre);
    }

    @Override
    public List<Joueur> findByLabel(Label label) {
        return joueurRepository.findByLabel(label);
    }

    @Override
    public List<Joueur> findByLabelIdLabel(Long id) {
        return joueurRepository.findByLabelIdLabel(id);
    }

    @Override
    public List<Joueur> findByOrderByTitleAsc() {
        return joueurRepository.findByOrderByTitleAsc();
    }

    @Override
    public List<Joueur> sortByTitleAndGenre() {
        return joueurRepository.sortByTitleAndGenre();
    }

    @Override
    public AlbumDTO convertEntityToDTO(Joueur a) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        AlbumDTO albumDTO = modelMapper.map(a, AlbumDTO.class);
        return albumDTO;
    }

    @Override
    public Joueur convertDTOToEntity(AlbumDTO a) {
        Joueur joueur = new Joueur();
        joueur = modelMapper.map(a, Joueur.class);
        return joueur;
    }
}


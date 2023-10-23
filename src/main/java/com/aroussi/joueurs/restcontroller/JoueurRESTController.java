package com.aroussi.joueurs.restcontroller;

import com.aroussi.joueurs.dto.AlbumDTO;
import com.aroussi.joueurs.entities.Joueur;
import com.aroussi.joueurs.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class JoueurRESTController {
    @Autowired
    JoueurService joueurService;

    @RequestMapping(value = "/allAlbums", method = RequestMethod.GET)
    public List<AlbumDTO> getAllAlbums() {
        return joueurService.getAllAlbums();
    }

    @RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
    public AlbumDTO getAlbumById(@PathVariable("id") Long id) {
        return joueurService.getAlbum(id);
    }

    @RequestMapping(path = "addAlbum", method = RequestMethod.POST)
    public AlbumDTO createAlbum(@RequestBody AlbumDTO a) {
        return joueurService.saveAlbum(a);
    }

    @RequestMapping(path = "/updateAlbum", method = RequestMethod.PUT)
    public AlbumDTO updateAlbum(@RequestBody AlbumDTO a) {
        return joueurService.updateAlbum(a);
    }

    @RequestMapping(value = "/deleteAlbum/{id}", method = RequestMethod.DELETE)
    public void deleteAlbum(@PathVariable("id") Long id) {
        joueurService.deleteAlbumById(id);
    }

    @RequestMapping(value = "/label/{idLabel}", method = RequestMethod.GET)
    public List<Joueur> getAlbumsByLabel(@PathVariable("idLabel") Long idLabel) {
        return joueurService.findByLabelIdLabel(idLabel);
    }
}

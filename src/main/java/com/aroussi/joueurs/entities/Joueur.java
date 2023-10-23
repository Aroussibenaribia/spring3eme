package com.aroussi.joueurs.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Joueur {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idAlbum;
    private String title;
    private String artist;
    private String genre;
    private Date releaseDate;
    @ManyToOne
    private Label label;
    @OneToOne
    private Image image;

    public Joueur() {
        super();
    }

    public Joueur(String title, String artist, String genre, Date releaseDate) {
        super();
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public Long getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Long idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Albums{" +
                "idAlbum=" + idAlbum +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}

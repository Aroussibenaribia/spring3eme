package com.aroussi.joueurs.dto;

import com.aroussi.joueurs.entities.Image;
import com.aroussi.joueurs.entities.Label;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlbumDTO {
    private Long idAlbum;
    private String title;
    private String artist;
    private String genre;
    private Date releaseDate;
    private Label label;
    private Image image;
}

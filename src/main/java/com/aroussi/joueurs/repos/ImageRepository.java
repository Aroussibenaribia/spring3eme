package com.aroussi.joueurs.repos;

import com.aroussi.joueurs.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}

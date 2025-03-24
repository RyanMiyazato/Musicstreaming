package com.example.musicstreaming.repository;

import com.example.musicstreaming.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
    List<Musica> findByTituloContaining(String titulo);
    List<Musica> findByArtista(String artista);
    List<Musica> findByGenero(String genero);
}
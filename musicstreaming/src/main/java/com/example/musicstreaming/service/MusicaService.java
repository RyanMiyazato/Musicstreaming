package com.example.musicstreaming.service;

import com.example.musicstreaming.entity.Musica;
import com.example.musicstreaming.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    public Musica adicionarMusica(Musica musica) {
        return musicaRepository.save(musica);
    }

    public void excluirMusica(Long id) {
        musicaRepository.deleteById(id);
    }

    public Musica atualizarMusica(Long id, Musica musicaAtualizada) {
        Optional<Musica> musicaExistente = musicaRepository.findById(id);
        if (musicaExistente.isPresent()) {
            Musica musica = musicaExistente.get();
            musica.setTitulo(musicaAtualizada.getTitulo());
            musica.setArtista(musicaAtualizada.getArtista());
            musica.setGenero(musicaAtualizada.getGenero());
            musica.setDuracao(musicaAtualizada.getDuracao());
            return musicaRepository.save(musica);
        } else {
            throw new RuntimeException("Música não encontrada com o ID: " + id);
        }
    }

    public List<Musica> buscarPorTitulo(String titulo) {
        return musicaRepository.findByTituloContaining(titulo);
    }

    public List<Musica> buscarPorArtista(String artista) {
        return musicaRepository.findByArtista(artista);
    }

    public List<Musica> buscarPorGenero(String genero) {
        return musicaRepository.findByGenero(genero);
    }

    public List<Musica> listarTodas() {
        return musicaRepository.findAll();
    }
}

package com.example.musicstreaming.controller;

import com.example.musicstreaming.entity.Musica;
import com.example.musicstreaming.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaService musicaService;

    @PostMapping
    public ResponseEntity<Musica> adicionarMusica(@RequestBody Musica musica) {
        Musica novaMusica = musicaService.adicionarMusica(musica);
        return ResponseEntity.ok(novaMusica);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMusica(@PathVariable Long id) {
        musicaService.excluirMusica(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Musica> atualizarMusica(@PathVariable Long id, @RequestBody Musica musicaAtualizada) {
        Musica musica = musicaService.atualizarMusica(id, musicaAtualizada);
        return ResponseEntity.ok(musica);
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Musica>> buscarPorTitulo(@PathVariable String titulo) {
        List<Musica> musicas = musicaService.buscarPorTitulo(titulo);
        return ResponseEntity.ok(musicas);
    }

    @GetMapping("/artista/{artista}")
    public ResponseEntity<List<Musica>> buscarPorArtista(@PathVariable String artista) {
        List<Musica> musicas = musicaService.buscarPorArtista(artista);
        return ResponseEntity.ok(musicas);
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Musica>> buscarPorGenero(@PathVariable String genero) {
        List<Musica> musicas = musicaService.buscarPorGenero(genero);
        return ResponseEntity.ok(musicas);
    }

    @GetMapping
    public ResponseEntity<List<Musica>> listarTodas() {
        List<Musica> musicas = musicaService.listarTodas();
        return ResponseEntity.ok(musicas);
    }
}

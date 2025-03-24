package com.example.musicstreaming.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String artista;
    private String genero;
    private int duracao; // Duração em segundos
}
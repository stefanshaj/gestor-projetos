package com.stefanhudson.desafio.gestor_projetos.model;

import jakarta.persistence.*;

@Entity
@Table
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private Atribuicao atribuicao;
}

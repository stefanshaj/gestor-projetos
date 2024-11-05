package com.stefanhudson.desafio.gestor_projetos.model;

import com.stefanhudson.desafio.gestor_projetos.dto.AtualizarProjetoDto;
import com.stefanhudson.desafio.gestor_projetos.dto.ProjetoDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
@Table
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataPrevisaoFim;
    private LocalDate dataFim;
    private String descricao;
    private String orcamento;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Risco risco ;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pessoa gerente ;

    public Projeto(ProjetoDto dto) {
        this.nome = dto.nome();
        this.dataInicio = dto.dataInicio();
        this.dataPrevisaoFim = dto.dataPrevisaoFim();
        this.dataFim = dto.dataFim();
        this.descricao = dto.descricao();
        this.orcamento = dto.orcamento();
        this.status = dto.status();
        this.risco = dto.risco();
        this.gerente = dto.gerente();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataPrevisaoFim() {
        return dataPrevisaoFim;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getOrcamento() {
        return orcamento;
    }

    public Status getStatus() {
        return status;
    }

    public Risco getRisco() {
        return risco;
    }

    public Pessoa getGerente() {
        return gerente;
    }

    public void atualizarDados(AtualizarProjetoDto dto) {
        this.nome = dto.nome();
        this.dataInicio = dto.dataInicio();
        this.dataPrevisaoFim = dto.dataPrevisaoFim();
        this.dataFim = dto.dataFim();
        this.descricao = dto.descricao();
        this.orcamento = dto.orcamento();
        this.status = dto.status();
        this.risco = dto.risco();
        this.gerente = dto.gerente();
    }
}

package com.stefanhudson.desafio.gestor_projetos.repository;

import com.stefanhudson.desafio.gestor_projetos.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    boolean existsByNome(String nome);
}

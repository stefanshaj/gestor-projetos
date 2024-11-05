package com.stefanhudson.desafio.gestor_projetos.dto;

import com.stefanhudson.desafio.gestor_projetos.model.Pessoa;
import com.stefanhudson.desafio.gestor_projetos.model.Projeto;
import com.stefanhudson.desafio.gestor_projetos.model.Risco;
import com.stefanhudson.desafio.gestor_projetos.model.Status;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AtualizarProjetoDto(
        @NotNull
        Long id,
        @NotNull
        String nome,
        LocalDate dataInicio,
        LocalDate dataPrevisaoFim,
        LocalDate dataFim,
        String descricao,
        String orcamento,
        Status status,
        Risco risco,
        @NotNull
        Pessoa gerente
) {

    public AtualizarProjetoDto(Projeto projeto) {
        this(projeto.getId(),
                projeto.getNome(),
                projeto.getDataInicio(),
                projeto.getDataPrevisaoFim(),
                projeto.getDataFim(),
                projeto.getDescricao(),
                projeto.getOrcamento(),
                projeto.getStatus(),
                projeto.getRisco(),
                projeto.getGerente()
        );
    }
}

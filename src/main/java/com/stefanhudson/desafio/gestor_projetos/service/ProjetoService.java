package com.stefanhudson.desafio.gestor_projetos.service;

import com.stefanhudson.desafio.gestor_projetos.dto.AtualizarProjetoDto;
import com.stefanhudson.desafio.gestor_projetos.dto.ProjetoDto;
import com.stefanhudson.desafio.gestor_projetos.exception.ValidacaoException;
import com.stefanhudson.desafio.gestor_projetos.model.Projeto;
import com.stefanhudson.desafio.gestor_projetos.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public void cadastrar(ProjetoDto dto) throws ValidacaoException {
        boolean jaCadastrado = projetoRepository.existsByNome(dto.nome());

        if (jaCadastrado) {
            throw new ValidacaoException("Dados já cadastrados para outro projeto!");
        }
        projetoRepository.save(new Projeto(dto));
    }

    public ProjetoDto buscarProjetoPorId(Long id) throws ValidacaoException {
        Optional<Projeto> optional = projetoRepository.findById(id);

        if (optional.isEmpty()) {
            throw new ValidacaoException("Projeto com ID " + id + " não encontrado");
        }

        return new ProjetoDto(optional.get());
    }

    public void atualizar(AtualizarProjetoDto dto) throws ValidacaoException {
        Projeto projeto = projetoRepository
                .getReferenceById(dto.id());
        projeto.atualizarDados(dto);
    }
}

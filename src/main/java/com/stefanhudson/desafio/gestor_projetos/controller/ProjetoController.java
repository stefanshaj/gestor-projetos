package com.stefanhudson.desafio.gestor_projetos.controller;

import com.stefanhudson.desafio.gestor_projetos.dto.AtualizarProjetoDto;
import com.stefanhudson.desafio.gestor_projetos.dto.ProjetoDto;
import com.stefanhudson.desafio.gestor_projetos.exception.ValidacaoException;
import com.stefanhudson.desafio.gestor_projetos.service.ProjetoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    @Transactional
    private ResponseEntity<String> cadastrarProjeto(@RequestBody @Valid ProjetoDto dto) {
        try {
            projetoService.cadastrar(dto);
            return ResponseEntity.ok().build();
        } catch (ValidacaoException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<ProjetoDto> buscaProjetoPorId(@PathVariable Long id){
        try {
            ProjetoDto dto = projetoService.buscarProjetoPorId(id);
            return ResponseEntity.ok(dto);
        } catch (ValidacaoException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/id")
    private ResponseEntity<String> atualizarProjeto(@RequestBody @Valid AtualizarProjetoDto dto) {
        try {
            projetoService.atualizar(dto);
            return ResponseEntity.ok().build();
        } catch (ValidacaoException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}

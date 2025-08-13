package com.projeto.financeiro.infrastructure.rest.controller;

import com.projeto.financeiro.application.ports.ReceitaServiceUseCase;
import com.projeto.financeiro.infrastructure.rest.dto.ReceitaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/receita")
public class ReceitaController {

    private final ReceitaServiceUseCase serviceUseCase;

    @PostMapping("/salvar")
    public ResponseEntity<Void> salvarReceita(@RequestBody ReceitaDTO receitaDTO) {
        serviceUseCase.salvarReceita(receitaDTO);
        return ResponseEntity.noContent().build();
    }
}

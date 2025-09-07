package com.projeto.financeiro.infrastructure.rest.controller;

import com.projeto.financeiro.application.ports.ReceitaServiceUseCase;
import com.projeto.financeiro.domain.modal.ReceitaResponse;
import com.projeto.financeiro.infrastructure.rest.dto.ReceitaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/receita")
public class ReceitaController {

    private final ReceitaServiceUseCase serviceUseCase;

    @GetMapping
    @Operation(summary = "Busca todas as receitas",
            description = "Retorna a lista de receitas do usuário")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "204", description = "Nenhuma receita encontrada")
    public ResponseEntity<List<ReceitaResponse>> buscarTodos() {
        log.info("Iniciando a busca pelas receitas.");
        var receitas = serviceUseCase.buscarTodos();
        if (receitas.isEmpty()) {
            log.info("Nenhuma receita encontrada.");
            return ResponseEntity.noContent().build();
        }
        log.info("Busca realizada com sucesso. Receitas: {}", receitas.size());
        return ResponseEntity.ok(receitas);
    }

    @PostMapping("/salvar")
    @Operation(summary = "Salva a receita mensal do usuário.",
            description = "Retorna noContent caso a receita seja inserida com sucesso.")
    @ApiResponse(responseCode = "204", description = "Receita salva com sucesso.")
    @ApiResponse(responseCode = "500", description = "Bad Request")
    public ResponseEntity<Void> salvarReceita(@RequestBody ReceitaDTO receitaDTO) {
        serviceUseCase.salvarReceita(receitaDTO);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/alterar/{id}")
    @Operation(summary = "Altera a receita mensal do usuário.",
            description = "Retorna noContent caso a receita seja alterada com sucesso.")
    @ApiResponse(responseCode = "200", description = "Receita alterada com sucesso.")
    @ApiResponse(responseCode = "500", description = "Bad Request")
    public ResponseEntity<ReceitaResponse> alterarReceita(@PathVariable String id,
                                                          @RequestBody ReceitaDTO receitaDTO) {
        return ResponseEntity.ok(serviceUseCase.alterarReceita(id, receitaDTO));
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta a receita mensal do usuário.",
            description = "Retorna noContent caso a receita seja deletada com sucesso.")
    @ApiResponse(responseCode = "204", description = "Receita deletada com sucesso.")
    @ApiResponse(responseCode = "500", description = "Bad Request")
    public ResponseEntity<Void> deletarReceita(@PathVariable String id) {
        serviceUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

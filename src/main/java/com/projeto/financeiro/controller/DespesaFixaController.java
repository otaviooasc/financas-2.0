package com.projeto.financeiro.controller;


import com.projeto.financeiro.business.ports.DespesaFixaServiceUseCase;
import com.projeto.financeiro.business.service.dto.DespesaFixaDTO;
import com.projeto.financeiro.business.service.dto.DespesaFixaResponseDTO;
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
@RequestMapping("/api/despesa-fixa")
public class DespesaFixaController {
    private final DespesaFixaServiceUseCase serviceUseCase;

    @GetMapping
    @Operation(summary = "Busca todas as despesas fixas", description = "Retorna a lista de despesas do usuário")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "204", description = "Não foi encontradas despesas")
    public ResponseEntity<List<DespesaFixaResponseDTO>> buscarTodos(){
        log.info("Iniciando a busca de despesas fixas.");
        var despesas = serviceUseCase.buscarTodos();
        if(despesas.isEmpty()){
            log.info(("Não foram encontradas despesas."));
            return ResponseEntity.noContent().build();
        }
        log.info("Busca realizada com sucesso. Despesas: {}", despesas.size());
        return ResponseEntity.ok(despesas);
    }

    @PostMapping("/salvar")
    @Operation(summary = "Salva a despesa fixa do usuário",
            description = "Retorna noContent caso a despesa seja salva com sucesso")
    @ApiResponse(responseCode = "200",description = "Despesa salva com sucesso")
    @ApiResponse(responseCode = "500",description = "Bad Request")
    public ResponseEntity<Void> salvarDespesaFixa(@RequestBody DespesaFixaDTO despesaFixaDTO){
        serviceUseCase.salvarDespesaFixa(despesaFixaDTO);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/alterar/{id}")
    @Operation(summary = "", description = "")
    @ApiResponse(responseCode = "200", description = "")
    @ApiResponse(responseCode = "500", description = "")
    public ResponseEntity<DespesaFixaResponseDTO> alterarDespesaFixa(@PathVariable String id, @RequestBody DespesaFixaDTO despesaFixaDTO){
        return ResponseEntity.ok(serviceUseCase.alterarDespesaFixa(id, despesaFixaDTO));
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar a despesa fixa do usuário",
            description = "Retorna noContent caso a despesa seja deletada com sucesso.")
    @ApiResponse(responseCode = "200" ,description = "Receita deletada com sucesso.")
    @ApiResponse(responseCode = "500" ,description = "Bad Request.")
    public ResponseEntity<Void> deletarDespesaFixa(@PathVariable String id){
        serviceUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

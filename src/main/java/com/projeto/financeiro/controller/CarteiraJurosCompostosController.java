package com.projeto.financeiro.controller;

import com.projeto.financeiro.business.ports.CarteiraJCServiceUseCase;
import com.projeto.financeiro.business.service.dto.CarteiraMensal;
import com.projeto.financeiro.business.service.dto.CarteiraMensalDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/juros-compostos")
@Tag(name = "Carteira Juros Compostos", description = "Operações relacionadas à carteira mensal do usuário")
public class CarteiraJurosCompostosController {

    private final CarteiraJCServiceUseCase serviceUseCase;

    @GetMapping("/buscar")
    @Operation(summary = "Retorna toda a carteira do usuário através do mes-ano.",
            description = "Retorna a carteira.")
    @ApiResponse(responseCode = "200", description = "Sucesso.")
    @ApiResponse(responseCode = "404", description = "Nenhuma carteira encontrada.")
    @ApiResponse(responseCode = "500", description = "Bad Request")
    public ResponseEntity<CarteiraMensal> buscarCarteiraMensal(
            @Parameter(example = "01-2025")
            @RequestParam String mesAnoCarteira) {

        return ResponseEntity.ok(serviceUseCase.buscarCarteiraMensal(mesAnoCarteira));
    }

    @GetMapping("/buscar-todos")
    @Operation(summary = "Retorna todas carteiras do usuário.",
            description = "Retorna todas carteiras.")
    @ApiResponse(responseCode = "200", description = "Sucesso.")
    @ApiResponse(responseCode = "204", description = "Nenhuma carteira encontrada.")
    @ApiResponse(responseCode = "500", description = "Bad Request")
    public ResponseEntity<List<CarteiraMensal>> buscarTodos() {

        var lista = serviceUseCase.buscarTodos();

        return lista.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(lista);
    }

    @PostMapping("/salvar")
    @Operation(summary = "Salva a carteira mensal do usuário.",
            description = "Retorna noContent caso a receita seja salva com sucesso.")
    @ApiResponse(responseCode = "204", description = "Carteira salva com sucesso.")
    @ApiResponse(responseCode = "404", description = "Carteira não encontrada.")
    @ApiResponse(responseCode = "500", description = "Bad Request")
    public ResponseEntity<Void> salvarCarteiraMensal(@RequestBody CarteiraMensalDTO carteiraMensalDTO) {

        serviceUseCase.salvarNovoMes(carteiraMensalDTO);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/alterar")
    @Operation(summary = "Altera a carteira mensal do usuário.",
            description = "Retorna a Carteira caso a receita seja alterada com sucesso.")
    @ApiResponse(responseCode = "200", description = "Carteira alterada com sucesso.")
    @ApiResponse(responseCode = "404", description = "Carteira não encontrada.")
    @ApiResponse(responseCode = "500", description = "Bad Request")
    public ResponseEntity<CarteiraMensal> alterarCarteiraMensal(@RequestBody CarteiraMensalDTO carteiraMensalDTO) {

        return ResponseEntity.ok(serviceUseCase.alterarCarteiraMes(carteiraMensalDTO));
    }

    @DeleteMapping("/deletar")
    @Operation(summary = "Deleta a carteira mensal do usuário.",
            description = "Retorna noContent caso a receita seja deletada com sucesso.")
    @ApiResponse(responseCode = "204", description = "Carteira deletada com sucesso.")
    @ApiResponse(responseCode = "404", description = "Carteira não encontrada.")
    @ApiResponse(responseCode = "500", description = "Bad Request")
    public ResponseEntity<Void> deletarCarteiraMensal(
            @Parameter(example = "01-2025")
            @RequestParam String mesAnoCarteira) {

        serviceUseCase.deletarMesCarteira(mesAnoCarteira);
        return ResponseEntity.noContent().build();
    }
}

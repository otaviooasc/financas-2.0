package com.projeto.financeiro.infrastructure.rest.controller;

import com.projeto.financeiro.application.ports.CarteiraJCServiceUseCase;
import com.projeto.financeiro.domain.modal.CarteiraMensal;
import com.projeto.financeiro.infrastructure.rest.dto.CarteiraMensalDTO;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/juros-compostos")
public class CarteiraJurosCompostos {

    private final CarteiraJCServiceUseCase serviceUseCase;

    @GetMapping("/buscar-carteira-mensal")
    public ResponseEntity<List<CarteiraMensal>> buscarCarteiraMensal(
            @Parameter(example = "01-2025")
            @RequestParam String mesAnoCarteira) {
        var carteiraMensal = serviceUseCase.buscarCarteiraMensal(mesAnoCarteira);
        if (carteiraMensal.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carteiraMensal);
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<CarteiraMensal>> buscarTodos() {
        var carteiraMensal = serviceUseCase.buscarTodos();
        if (carteiraMensal.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carteiraMensal);
    }

    @PostMapping("/salvar-carteira-mensal")
    public ResponseEntity<Void> salvarCarteiraMensal(@RequestBody CarteiraMensalDTO carteiraMensalDTO) {
        serviceUseCase.salvarNovoMes(carteiraMensalDTO);
        return ResponseEntity.noContent().build();
    }
}

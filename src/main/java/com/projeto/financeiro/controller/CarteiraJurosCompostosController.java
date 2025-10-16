package com.projeto.financeiro.controller;

import com.projeto.financeiro.business.ports.CarteiraJCServiceUseCase;
import com.projeto.financeiro.business.service.dto.CarteiraMensal;
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
public class CarteiraJurosCompostosController {

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
    public ResponseEntity<Void> salvarCarteiraMensal(@RequestBody com.projeto.financeiro.business.service.dto.CarteiraMensalDTO carteiraMensalDTO) {
        serviceUseCase.salvarNovoMes(carteiraMensalDTO);
        return ResponseEntity.noContent().build();
    }
}

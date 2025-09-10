package com.projeto.financeiro.infrastructure.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record CarteiraMensalDTO(
        @Schema(description = "Mês e Ano da carteira", example = "01-2025")
        String mesAnoCarteira,
        @Schema(description = "Valor final do último mês", example = "100.00", nullable = true)
        BigDecimal valorUltimoMes,
        @Schema(description = "Renda mensal", example = "100.00")
        BigDecimal rendaMensal,
        @Schema(description = "Valor da carteira mensal", example = "250.00")
        BigDecimal carteiraAtual,
        @Schema(description = "Valor da valorização mensal", example = "150.00")
        BigDecimal valorizacao) {}

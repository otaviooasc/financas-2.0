package com.projeto.financeiro.infrastructure.rest.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record DespesaDTO(UUID id, BigDecimal aluguel, BigDecimal condicional, BigDecimal planoSaude,
                         BigDecimal impostoIptu, BigDecimal impostoIpva, BigDecimal seguro, BigDecimal telefonia,
                         BigDecimal financiamento, BigDecimal empredimento, BigDecimal educacao) {
}

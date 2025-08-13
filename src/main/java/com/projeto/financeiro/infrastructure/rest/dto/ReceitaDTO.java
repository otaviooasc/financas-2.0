package com.projeto.financeiro.infrastructure.rest.dto;

import java.math.BigDecimal;

public record ReceitaDTO(BigDecimal salarioLiquido,
                         BigDecimal rendimentoAluguel,
                         BigDecimal rendimentoAplicacoes) {
}

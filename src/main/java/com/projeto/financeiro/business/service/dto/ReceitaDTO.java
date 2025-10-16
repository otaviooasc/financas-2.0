package com.projeto.financeiro.business.service.dto;

import java.math.BigDecimal;

public record ReceitaDTO(BigDecimal salarioLiquido,
                         BigDecimal rendimentoAluguel,
                         BigDecimal rendimentoAplicacoes) {
}

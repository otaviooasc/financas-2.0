package com.projeto.financeiro.domain.modal;

import java.math.BigDecimal;
import java.util.UUID;

public record ReceitaResponse(UUID id,
                              BigDecimal salarioLiquido,
                              BigDecimal rendimentoAluguel,
                              BigDecimal rendimentoAplicacoes) {
}

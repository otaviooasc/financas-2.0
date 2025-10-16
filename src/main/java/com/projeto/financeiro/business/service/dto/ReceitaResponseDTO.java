package com.projeto.financeiro.business.service.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ReceitaResponseDTO(UUID id,
                                 BigDecimal salarioLiquido,
                                 BigDecimal rendimentoAluguel,
                                 BigDecimal rendimentoAplicacoes) {
}

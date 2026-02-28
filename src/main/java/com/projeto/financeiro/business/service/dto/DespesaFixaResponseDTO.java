package com.projeto.financeiro.business.service.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record DespesaFixaResponseDTO(UUID id,
                                     BigDecimal aluguel,
                                     BigDecimal luz,
                                     BigDecimal agua,
                                     BigDecimal feira,
                                     BigDecimal financiamento) {
}

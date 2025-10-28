package com.projeto.financeiro.business.service.dto;

import java.math.BigDecimal;

public record DespesaFixaDTO(BigDecimal aluguel,
                             BigDecimal luz,
                             BigDecimal agua,
                             BigDecimal feira,
                             BigDecimal financiamento) {
}

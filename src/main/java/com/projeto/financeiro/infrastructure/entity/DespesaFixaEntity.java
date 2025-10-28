package com.projeto.financeiro.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DESPESA_FIXA_TABLE")
public class DespesaFixaEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private BigDecimal aluguel;
    private BigDecimal luz;
    private BigDecimal agua;
    private BigDecimal feira;
    private BigDecimal financiamento;
}

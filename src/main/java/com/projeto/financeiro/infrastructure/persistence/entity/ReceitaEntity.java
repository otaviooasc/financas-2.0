package com.projeto.financeiro.infrastructure.persistence.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RECEITA_TABLE")
public class ReceitaEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private BigDecimal salarioLiquido;
    private BigDecimal rendimentoAluguel;
    private BigDecimal rendimentoAplicacoes;
}

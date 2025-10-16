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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CARTEIRA_MENSAL")
public class CarteiraMensalEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private String mesAnoCarteira;
    private BigDecimal valorUltimoMes;
    private BigDecimal rendaMensal;
    private BigDecimal carteiraAtual;
    private BigDecimal valorizacao;
}

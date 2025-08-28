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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "DESPESA_FIXA_TABLE")
public class DespesaEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private BigDecimal aluguel;
    private BigDecimal condicional;
    private BigDecimal planoSaude;
    private BigDecimal impostoIptu;
    private BigDecimal impostoIpva;
    private BigDecimal seguro;
    private BigDecimal telefonia;
    private BigDecimal financiamento;
    private BigDecimal empredimento;
    private BigDecimal educacao;

}

package com.projeto.financeiro.business.service.dto;

import java.math.BigDecimal;

public record CarteiraMensal(String mesCarteira,
                             BigDecimal valorUltimoMes,
                             BigDecimal rendaMensal,
                             BigDecimal carteiraAtual,
                             BigDecimal valorizacao,
                             BigDecimal gastoMensal,
                             String porcAlertaGastoMensal,
                             String porcVariacaoMensal) {}

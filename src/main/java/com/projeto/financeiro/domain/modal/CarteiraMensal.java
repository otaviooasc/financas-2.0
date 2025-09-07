package com.projeto.financeiro.domain.modal;

import java.math.BigDecimal;

public record CarteiraMensal(String mesCarteira,
                             BigDecimal valorUltimoMes,
                             BigDecimal rendaMensal,
                             BigDecimal carteiraAtual,
                             BigDecimal valorizacao,
                             BigDecimal gastoMensal,
                             String porcAlertaGastoMensal,
                             String porcVariacaoMensal) {}

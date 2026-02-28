package com.projeto.financeiro.business.service.dto;

import java.math.BigDecimal;

public record CarteiraMensal(String mesAnoCarteira,
                             BigDecimal valorUltimoMes,
                             BigDecimal rendaMensal,
                             BigDecimal carteiraAtual,
                             BigDecimal variacao,
                             BigDecimal gastoMensal,
                             String porcAlertaGastoMensal,
                             String porcVariacaoMensal) {}

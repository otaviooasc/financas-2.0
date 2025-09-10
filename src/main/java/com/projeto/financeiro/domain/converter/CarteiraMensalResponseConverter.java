package com.projeto.financeiro.domain.converter;

import com.projeto.financeiro.domain.modal.CarteiraMensal;
import com.projeto.financeiro.infrastructure.persistence.entity.CarteiraMensalEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class CarteiraMensalResponseConverter {

    public final CarteiraMensal carteiraMensalResponseConverter(CarteiraMensalEntity entity) {
        var gastoMensal = calcularGastoMensal(entity);

        return new CarteiraMensal(entity.getMesAnoCarteira(),
                entity.getValorUltimoMes(),
                entity.getRendaMensal(),
                entity.getCarteiraAtual(),
                entity.getValorizacao(),
                gastoMensal,
                calcularPorcentagemAlertaGastoMensal(entity.getRendaMensal(), gastoMensal),
                calcularPorcentagemVariacaoMensal(entity.getCarteiraAtual(), entity.getValorUltimoMes()));
    }

    private BigDecimal calcularGastoMensal(CarteiraMensalEntity entity) {
        return entity.getValorUltimoMes()
                .add(entity.getRendaMensal())
                .add(entity.getValorizacao())
                .subtract(entity.getCarteiraAtual());
    }

    private String calcularPorcentagemAlertaGastoMensal(BigDecimal rendaMensal, BigDecimal gastoMensal) {
        return gastoMensal
                .divide(rendaMensal, 10, RoundingMode.DOWN)
                .multiply(BigDecimal.valueOf(100))
                .setScale(2, RoundingMode.DOWN) + "%";
    }

    private String calcularPorcentagemVariacaoMensal(BigDecimal carteiraAtual, BigDecimal valorUltimoMes) {
        BigDecimal variacaoMensal;
        try {
            variacaoMensal = carteiraAtual
                .subtract(valorUltimoMes)
                .divide(valorUltimoMes, 10, RoundingMode.DOWN)
                .multiply(BigDecimal.valueOf(100))
                .setScale(2, RoundingMode.DOWN);
        } catch (Exception e) {
            variacaoMensal = new BigDecimal(100);
        }
        return variacaoMensal + "%";
    }
}

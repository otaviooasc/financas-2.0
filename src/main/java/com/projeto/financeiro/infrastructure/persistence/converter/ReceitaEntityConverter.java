package com.projeto.financeiro.infrastructure.persistence.converter;

import com.projeto.financeiro.infrastructure.persistence.entity.ReceitaEntity;
import com.projeto.financeiro.infrastructure.rest.dto.ReceitaDTO;
import org.springframework.stereotype.Component;

@Component
public class ReceitaEntityConverter {

    public final ReceitaEntity receitaEntityConverter(ReceitaDTO receitaDTO) {

        return ReceitaEntity
                .builder()
                .rendimentoAluguel(receitaDTO.rendimentoAluguel())
                .rendimentoAplicacoes(receitaDTO.rendimentoAplicacoes())
                .salarioLiquido(receitaDTO.salarioLiquido())
                .build();
    }
}

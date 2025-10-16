package com.projeto.financeiro.business.service.converter;

import com.projeto.financeiro.infrastructure.entity.ReceitaEntity;
import com.projeto.financeiro.business.service.dto.ReceitaDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

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

    public final ReceitaEntity receitaEntityConverter(UUID id, ReceitaDTO receitaDTO) {

        return ReceitaEntity
                .builder()
                .id(id)
                .rendimentoAluguel(receitaDTO.rendimentoAluguel())
                .rendimentoAplicacoes(receitaDTO.rendimentoAplicacoes())
                .salarioLiquido(receitaDTO.salarioLiquido())
                .build();
    }
}

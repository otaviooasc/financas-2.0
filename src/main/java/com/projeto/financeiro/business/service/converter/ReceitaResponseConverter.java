package com.projeto.financeiro.business.service.converter;

import com.projeto.financeiro.business.service.dto.ReceitaResponseDTO;
import com.projeto.financeiro.infrastructure.entity.ReceitaEntity;
import org.springframework.stereotype.Component;

@Component
public class ReceitaResponseConverter {

    public final ReceitaResponseDTO receitaResponseConverter(ReceitaEntity entity) {
        return new ReceitaResponseDTO(entity.getId(),
                entity.getSalarioLiquido(),
                entity.getRendimentoAluguel(),
                entity.getRendimentoAplicacoes());
    }
}

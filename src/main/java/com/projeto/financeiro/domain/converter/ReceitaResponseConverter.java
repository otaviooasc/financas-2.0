package com.projeto.financeiro.domain.converter;

import com.projeto.financeiro.domain.modal.ReceitaResponse;
import com.projeto.financeiro.infrastructure.persistence.entity.ReceitaEntity;
import org.springframework.stereotype.Component;

@Component
public class ReceitaResponseConverter {

    public final ReceitaResponse receitaResponseConverter(ReceitaEntity entity) {
        return new ReceitaResponse(entity.getId(),
                entity.getSalarioLiquido(),
                entity.getRendimentoAluguel(),
                entity.getRendimentoAplicacoes());
    }
}

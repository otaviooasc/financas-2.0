package com.projeto.financeiro.business.service.converter;

import com.projeto.financeiro.business.service.dto.DespesaFixaResponseDTO;
import com.projeto.financeiro.infrastructure.entity.DespesaFixaEntity;
import org.springframework.stereotype.Component;

@Component

public class DespesaFixaResponseConverter {

    public final DespesaFixaResponseDTO despesaFixaResponseConverter(DespesaFixaEntity entity){
        return new DespesaFixaResponseDTO(entity.getId(),
                entity.getAluguel(),
                entity.getLuz(),
                entity.getAgua(),
                entity.getFeira(),
                entity.getFinanciamento());
    }
}

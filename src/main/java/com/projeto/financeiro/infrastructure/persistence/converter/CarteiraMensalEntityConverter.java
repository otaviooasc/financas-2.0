package com.projeto.financeiro.infrastructure.persistence.converter;

import com.projeto.financeiro.infrastructure.persistence.entity.CarteiraMensalEntity;
import com.projeto.financeiro.infrastructure.rest.dto.CarteiraMensalDTO;
import org.springframework.stereotype.Component;

@Component
public class CarteiraMensalEntityConverter {

    public final CarteiraMensalEntity converterDtoToEntity(CarteiraMensalDTO receitaDTO) {

        return CarteiraMensalEntity
                .builder()
                .mesAnoCarteira(receitaDTO.mesAnoCarteira())
                .rendaMensal(receitaDTO.rendaMensal())
                .carteiraAtual(receitaDTO.carteiraAtual())
                .valorizacao(receitaDTO.valorizacao())
                .build();
    }
}

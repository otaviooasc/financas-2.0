package com.projeto.financeiro.business.service.converter;

import com.projeto.financeiro.infrastructure.entity.CarteiraMensalEntity;
import com.projeto.financeiro.business.service.dto.CarteiraMensalDTO;
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

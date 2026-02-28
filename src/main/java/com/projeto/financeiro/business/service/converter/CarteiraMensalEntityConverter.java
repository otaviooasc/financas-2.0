package com.projeto.financeiro.business.service.converter;

import com.projeto.financeiro.infrastructure.entity.CarteiraMensalEntity;
import com.projeto.financeiro.business.service.dto.CarteiraMensalDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarteiraMensalEntityConverter {

    public final CarteiraMensalEntity converterDtoToEntity(CarteiraMensalDTO receitaDTO) {

        return CarteiraMensalEntity
                .builder()
                .mesAnoCarteira(receitaDTO.mesAnoCarteira())
                .rendaMensal(receitaDTO.rendaMensal())
                .carteiraAtual(receitaDTO.carteiraAtual())
                .variacao(receitaDTO.variacao())
                .build();
    }

    public final CarteiraMensalEntity convertDtoToEntityUpdate(CarteiraMensalDTO carteiraMensalDTO, CarteiraMensalEntity carteirasEntity) {
        carteirasEntity.setRendaMensal(carteiraMensalDTO.rendaMensal());
        carteirasEntity.setValorUltimoMes(carteiraMensalDTO.valorUltimoMes());
        carteirasEntity.setCarteiraAtual(carteiraMensalDTO.carteiraAtual());
        carteirasEntity.setVariacao(carteiraMensalDTO.variacao());

        return carteirasEntity;
    }
}

package com.projeto.financeiro.business.service.converter;

import com.projeto.financeiro.business.service.dto.DespesaFixaDTO;
import com.projeto.financeiro.infrastructure.entity.DespesaFixaEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DespesaFixaEntityConverter {
    public final DespesaFixaEntity despesaFixaEntityConverter(DespesaFixaDTO despesaFixaDTO){
        return DespesaFixaEntity
                .builder()
                .aluguel(despesaFixaDTO.aluguel())
                .luz(despesaFixaDTO.luz())
                .agua(despesaFixaDTO.agua())
                .feira(despesaFixaDTO.feira())
                .financiamento(despesaFixaDTO.financiamento())
                .build();
    }

    public final DespesaFixaEntity despesaFixaEntityConverter(UUID id, DespesaFixaDTO despesaFixaDTO){
        return DespesaFixaEntity
                .builder()
                .aluguel(despesaFixaDTO.aluguel())
                .luz(despesaFixaDTO.luz())
                .agua(despesaFixaDTO.agua())
                .feira(despesaFixaDTO.feira())
                .financiamento(despesaFixaDTO.financiamento())
                .build();
    }
}

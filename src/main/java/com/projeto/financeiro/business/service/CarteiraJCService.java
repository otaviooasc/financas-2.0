package com.projeto.financeiro.business.service;


import com.projeto.financeiro.application.utils.DataUtils;
import com.projeto.financeiro.business.ports.CarteiraJCServiceUseCase;
import com.projeto.financeiro.business.service.converter.CarteiraMensalEntityConverter;
import com.projeto.financeiro.business.service.converter.CarteiraMensalResponseConverter;
import com.projeto.financeiro.business.service.dto.CarteiraMensal;
import com.projeto.financeiro.infrastructure.repository.CarteiraJCRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarteiraJCService implements CarteiraJCServiceUseCase {

    private final CarteiraJCRepositoryAdapter repositoryAdapter;
    private final CarteiraMensalEntityConverter converterEntity;
    private final CarteiraMensalResponseConverter converterReponse;

    @Override
    public List<CarteiraMensal> buscarCarteiraMensal(String mesAnoCarteira) {
        return repositoryAdapter.findBymesAnoCarteira(mesAnoCarteira)
                .stream().map(converterReponse::carteiraMensalResponseConverter)
                .toList();
    }

    @Override
    public List<CarteiraMensal> buscarTodos() {
        return repositoryAdapter.findAll()
                .stream().map(converterReponse::carteiraMensalResponseConverter)
                .toList();
    }

    @Override
    public void salvarNovoMes(com.projeto.financeiro.business.service.dto.CarteiraMensalDTO carteiraMensalDTO) {
        var mesAnterior = DataUtils.getMesAnterior(carteiraMensalDTO.mesAnoCarteira());

        var carteiraMesPassado = repositoryAdapter.findBymesAnoCarteira(mesAnterior);

        var entity = converterEntity.converterDtoToEntity(carteiraMensalDTO);

        if (!carteiraMesPassado.isEmpty()) {
            entity.setValorUltimoMes(carteiraMesPassado.getFirst().getCarteiraAtual());
        } else if (carteiraMensalDTO.valorUltimoMes() != null) {
            entity.setValorUltimoMes(carteiraMensalDTO.valorUltimoMes());
        } else {
            entity.setValorUltimoMes(new BigDecimal(0));
        }

        repositoryAdapter.save(entity);
    }
}

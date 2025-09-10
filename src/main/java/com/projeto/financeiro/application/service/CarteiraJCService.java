package com.projeto.financeiro.application.service;

import com.projeto.financeiro.application.ports.CarteiraJCServiceUseCase;
import com.projeto.financeiro.domain.converter.CarteiraMensalResponseConverter;
import com.projeto.financeiro.domain.modal.CarteiraMensal;
import com.projeto.financeiro.infrastructure.persistence.converter.CarteiraMensalEntityConverter;
import com.projeto.financeiro.infrastructure.persistence.repository.CarteiraJCRepositoryAdapter;
import com.projeto.financeiro.infrastructure.rest.dto.CarteiraMensalDTO;
import com.projeto.financeiro.shared.utils.DataUtils;
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
    public void salvarNovoMes(CarteiraMensalDTO carteiraMensalDTO) {
        var mesAnterior = DataUtils.getMesAnterior(carteiraMensalDTO.mesAnoCarteira());

        var carteiraMesPassado = repositoryAdapter.findBymesAnoCarteira(mesAnterior);

        var entity = converterEntity.converterDtoToEntity(carteiraMensalDTO);

        if(!carteiraMesPassado.isEmpty()) {
            entity.setValorUltimoMes(carteiraMesPassado.getFirst().getCarteiraAtual());
        } else if(carteiraMensalDTO.valorUltimoMes() != null) {
            entity.setValorUltimoMes(carteiraMensalDTO.valorUltimoMes());
        } else {
            entity.setValorUltimoMes(new BigDecimal(0));
        }

        repositoryAdapter.save(entity);
    }
}

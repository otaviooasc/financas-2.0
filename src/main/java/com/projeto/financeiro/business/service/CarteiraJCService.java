package com.projeto.financeiro.business.service;


import com.projeto.financeiro.application.exceptions.NaoFoiEncontradoException;
import com.projeto.financeiro.application.utils.DataUtils;
import com.projeto.financeiro.business.ports.CarteiraJCServiceUseCase;
import com.projeto.financeiro.business.service.converter.CarteiraMensalEntityConverter;
import com.projeto.financeiro.business.service.converter.CarteiraMensalResponseConverter;
import com.projeto.financeiro.business.service.dto.CarteiraMensal;
import com.projeto.financeiro.business.service.dto.CarteiraMensalDTO;
import com.projeto.financeiro.infrastructure.repository.CarteiraJCRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarteiraJCService implements CarteiraJCServiceUseCase {

    private final CarteiraJCRepositoryAdapter repositoryAdapter;
    private final CarteiraMensalEntityConverter converterEntity;
    private final CarteiraMensalResponseConverter converterReponse;

    @Override
    public CarteiraMensal buscarCarteiraMensal(String mesAnoCarteira) {
        var carteira = repositoryAdapter.findByMesAnoCarteira(mesAnoCarteira);

        if (carteira == null || carteira.getMesAnoCarteira().isEmpty()) {
            throw new NaoFoiEncontradoException("Carteira não encontrada.");
        }
        return converterReponse.carteiraMensalResponseConverter(carteira);
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

        var carteiraMesPassado = repositoryAdapter.findByMesAnoCarteira(mesAnterior);

        var entity = converterEntity.converterDtoToEntity(carteiraMensalDTO);

        var valorUltimoMes = BigDecimal.ZERO;
        if (carteiraMesPassado != null && !carteiraMesPassado.getMesAnoCarteira().isEmpty()) {
            valorUltimoMes = carteiraMesPassado.getCarteiraAtual();
        }

        entity.setValorUltimoMes(valorUltimoMes);

        repositoryAdapter.save(entity);
    }

    @Override
    public CarteiraMensal alterarCarteiraMes(CarteiraMensalDTO carteiraMensalDTO) {

        var carteira = repositoryAdapter.findByMesAnoCarteira(carteiraMensalDTO.mesAnoCarteira());

        if (carteira == null || carteira.getMesAnoCarteira().isEmpty()) {
            throw new NaoFoiEncontradoException("Carteira não encontrada.");
        }

        return converterReponse.carteiraMensalResponseConverter(
                repositoryAdapter.save(converterEntity.convertDtoToEntityUpdate(carteiraMensalDTO, carteira))
        );
    }
}

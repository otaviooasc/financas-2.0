package com.projeto.financeiro.application.service;

import com.projeto.financeiro.application.ports.ReceitaServiceUseCase;
import com.projeto.financeiro.infrastructure.persistence.converter.ReceitaEntityConverter;
import com.projeto.financeiro.infrastructure.persistence.repository.ReceitaRepositoryAdapter;
import com.projeto.financeiro.infrastructure.rest.dto.ReceitaDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReceitaService implements ReceitaServiceUseCase {

    private final ReceitaEntityConverter converter;
    private final ReceitaRepositoryAdapter repositoryAdapter;

    @Override
    public void salvarReceita(ReceitaDTO receitaDTO) {
        repositoryAdapter.save(converter.receitaEntityConverter(receitaDTO));
    }
}

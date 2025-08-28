package com.projeto.financeiro.application.service;

import com.projeto.financeiro.application.ports.ReceitaServiceUseCase;
import com.projeto.financeiro.domain.converter.ReceitaResponseConverter;
import com.projeto.financeiro.domain.exceptions.NaoFoiEncontradoException;
import com.projeto.financeiro.domain.modal.ReceitaResponse;
import com.projeto.financeiro.infrastructure.persistence.converter.ReceitaEntityConverter;
import com.projeto.financeiro.infrastructure.persistence.repository.ReceitaRepositoryAdapter;
import com.projeto.financeiro.infrastructure.rest.dto.ReceitaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReceitaService implements ReceitaServiceUseCase {

    private final ReceitaEntityConverter converterEntity;
    private final ReceitaResponseConverter converterResponse;
    private final ReceitaRepositoryAdapter repositoryAdapter;

    @Override
    public List<ReceitaResponse> buscarTodos() {
        return repositoryAdapter.findAll()
                .stream().map(converterResponse::receitaResponseConverter)
                .toList();
    }

    @Override
    public void salvarReceita(ReceitaDTO receitaDTO) {
        repositoryAdapter.save(converterEntity.receitaEntityConverter(receitaDTO));
    }

    @Override
    public ReceitaResponse alterarReceita(String id, ReceitaDTO receitaDTO) {
        repositoryAdapter.findById(UUID.fromString(id))
                .orElseThrow(() -> new NaoFoiEncontradoException("Nenhuma receita encontrada com esse id: " + id));

        return converterResponse
                .receitaResponseConverter(
                        repositoryAdapter.save(
                                converterEntity
                                        .receitaEntityConverter(UUID.fromString(id), receitaDTO)
                        )
                );
    }

    @Override
    public void deletar(String idReceita) {
        repositoryAdapter.findById(UUID.fromString(idReceita))
                .orElseThrow(() -> new NaoFoiEncontradoException("Nenhuma receita encontrado com esse id: " + idReceita));
        repositoryAdapter.deleteById(UUID.fromString(idReceita));
    }
}

package com.projeto.financeiro.business.service;

import com.projeto.financeiro.business.ports.ReceitaServiceUseCase;
import com.projeto.financeiro.business.service.converter.ReceitaResponseConverter;
import com.projeto.financeiro.application.exceptions.NaoFoiEncontradoException;
import com.projeto.financeiro.business.service.dto.ReceitaResponseDTO;
import com.projeto.financeiro.business.service.converter.ReceitaEntityConverter;
import com.projeto.financeiro.infrastructure.repository.ReceitaRepositoryAdapter;
import com.projeto.financeiro.business.service.dto.ReceitaDTO;
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
    public List<ReceitaResponseDTO> buscarTodos() {
        return repositoryAdapter.findAll()
                .stream().map(converterResponse::receitaResponseConverter)
                .toList();
    }

    @Override
    public void salvarReceita(ReceitaDTO receitaDTO) {
        repositoryAdapter.save(converterEntity.receitaEntityConverter(receitaDTO));
    }

    @Override
    public ReceitaResponseDTO alterarReceita(String id, ReceitaDTO receitaDTO) {
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

package com.projeto.financeiro.business.service;

import com.projeto.financeiro.application.exceptions.NaoFoiEncontradoException;
import com.projeto.financeiro.business.ports.DespesaFixaServiceUseCase;
import com.projeto.financeiro.business.service.converter.DespesaFixaEntityConverter;
import com.projeto.financeiro.business.service.converter.DespesaFixaResponseConverter;
import com.projeto.financeiro.business.service.dto.DespesaFixaDTO;
import com.projeto.financeiro.business.service.dto.DespesaFixaResponseDTO;
import com.projeto.financeiro.infrastructure.repository.DespesaFixaRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DespesaFixaService implements DespesaFixaServiceUseCase {

    private final DespesaFixaEntityConverter converterEntity;
    private final DespesaFixaResponseConverter converterResponse;
    private final DespesaFixaRepositoryAdapter repositoryAdapter;

    @Override
    public List<DespesaFixaResponseDTO> buscarTodos() {
        return repositoryAdapter.findAll()
                .stream().map(converterResponse::despesaFixaResponseConverter)
                .toList();
    }

    @Override
    public void salvarDespesaFixa(DespesaFixaDTO despesaFixaDTO) {
        repositoryAdapter.save(converterEntity.despesaFixaEntityConverter(despesaFixaDTO));
    }

    @Override
    public DespesaFixaResponseDTO alterarDespesaFixa(String id, DespesaFixaDTO despesaFixaDTO) {
        repositoryAdapter.findById(UUID.fromString(id)).orElseThrow(() -> new NaoFoiEncontradoException("Nenhuma despesa encontrada com esse id: " + id));

        return converterResponse
                .despesaFixaResponseConverter(
                        repositoryAdapter.save(
                                converterEntity
                                        .despesaFixaEntityConverter(UUID.fromString(id), despesaFixaDTO)
                        )
                );
    }

    @Override
    public void deletar(String idDespesaFixa) {
        repositoryAdapter.findById(UUID.fromString(idDespesaFixa))
                .orElseThrow(() -> new NaoFoiEncontradoException("Nenhuma despesa encontrada com esse id: " +
                        idDespesaFixa));
        repositoryAdapter.deleteById(UUID.fromString(idDespesaFixa));
    }
}

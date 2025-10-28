package com.projeto.financeiro.business.service;

import com.projeto.financeiro.business.ports.DespesaFixaServiceUseCase;
import com.projeto.financeiro.business.service.dto.DespesaFixaDTO;
import com.projeto.financeiro.business.service.dto.DespesaFixaResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DespesaFixaService implements DespesaFixaServiceUseCase {

    @Override
    public List<DespesaFixaResponseDTO> buscarTodos() {
        return List.of();
    }

    @Override
    public void salvarDespesaFixa(DespesaFixaDTO despesaFixaDTO) {

    }

    @Override
    public DespesaFixaResponseDTO alterarDespesaFixa(String id, DespesaFixaDTO despesaFixaDTO) {
        return null;
    }

    @Override
    public void deletar(String idDespesaFixa) {

    }
}

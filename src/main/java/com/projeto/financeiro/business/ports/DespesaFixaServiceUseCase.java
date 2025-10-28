package com.projeto.financeiro.business.ports;

import com.projeto.financeiro.business.service.dto.DespesaFixaDTO;
import com.projeto.financeiro.business.service.dto.DespesaFixaResponseDTO;

import java.util.List;

public interface DespesaFixaServiceUseCase {
    List<DespesaFixaResponseDTO> buscarTodos();

    void salvarDespesaFixa(DespesaFixaDTO despesaFixaDTO);

    DespesaFixaResponseDTO alterarDespesaFixa(String id, DespesaFixaDTO despesaFixaDTO);

    void deletar(String idDespesaFixa);
}

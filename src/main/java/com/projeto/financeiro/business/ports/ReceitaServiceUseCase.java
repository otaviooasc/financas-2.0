package com.projeto.financeiro.business.ports;

import com.projeto.financeiro.business.service.dto.ReceitaResponseDTO;
import com.projeto.financeiro.business.service.dto.ReceitaDTO;

import java.util.List;

public interface ReceitaServiceUseCase {
    List<ReceitaResponseDTO> buscarTodos();

    void salvarReceita(ReceitaDTO receitaDTO);

    ReceitaResponseDTO alterarReceita(String id, ReceitaDTO receitaDTO);

    void deletar(String idReceita);
}

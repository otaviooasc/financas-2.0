package com.projeto.financeiro.application.ports;

import com.projeto.financeiro.domain.modal.ReceitaResponse;
import com.projeto.financeiro.infrastructure.rest.dto.ReceitaDTO;

import java.util.List;

public interface ReceitaServiceUseCase {
    List<ReceitaResponse> buscarTodos();

    void salvarReceita(ReceitaDTO receitaDTO);

    ReceitaResponse alterarReceita(String id, ReceitaDTO receitaDTO);

    void deletar(String idReceita);
}

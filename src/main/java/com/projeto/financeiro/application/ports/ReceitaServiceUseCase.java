package com.projeto.financeiro.application.ports;

import com.projeto.financeiro.infrastructure.rest.dto.ReceitaDTO;

public interface ReceitaServiceUseCase {
    void salvarReceita(ReceitaDTO receitaDTO);
}

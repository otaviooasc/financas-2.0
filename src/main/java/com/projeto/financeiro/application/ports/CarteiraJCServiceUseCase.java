package com.projeto.financeiro.application.ports;

import com.projeto.financeiro.domain.modal.CarteiraMensal;
import com.projeto.financeiro.infrastructure.rest.dto.CarteiraMensalDTO;

import java.util.List;

public interface CarteiraJCServiceUseCase {
    List<CarteiraMensal> buscarCarteiraMensal(String mesAnoCarteira);

    List<CarteiraMensal> buscarTodos();

    void salvarNovoMes(CarteiraMensalDTO carteiraMensalDTO);
}

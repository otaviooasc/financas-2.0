package com.projeto.financeiro.business.ports;

import com.projeto.financeiro.business.service.dto.CarteiraMensal;

import java.util.List;

public interface CarteiraJCServiceUseCase {
    List<CarteiraMensal> buscarCarteiraMensal(String mesAnoCarteira);

    List<CarteiraMensal> buscarTodos();

    void salvarNovoMes(com.projeto.financeiro.business.service.dto.CarteiraMensalDTO carteiraMensalDTO);
}

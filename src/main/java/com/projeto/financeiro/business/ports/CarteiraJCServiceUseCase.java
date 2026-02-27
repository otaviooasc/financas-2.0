package com.projeto.financeiro.business.ports;

import com.projeto.financeiro.business.service.dto.CarteiraMensal;
import com.projeto.financeiro.business.service.dto.CarteiraMensalDTO;

import java.util.List;

public interface CarteiraJCServiceUseCase {
    CarteiraMensal buscarCarteiraMensal(String mesAnoCarteira);

    List<CarteiraMensal> buscarTodos();

    void salvarNovoMes(CarteiraMensalDTO carteiraMensalDTO);

    CarteiraMensal alterarCarteiraMes(CarteiraMensalDTO carteiraMensalDTO);
}

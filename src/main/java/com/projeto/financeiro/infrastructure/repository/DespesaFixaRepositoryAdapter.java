package com.projeto.financeiro.infrastructure.repository;

import com.projeto.financeiro.infrastructure.entity.DespesaFixaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DespesaFixaRepositoryAdapter extends JpaRepository<DespesaFixaEntity,UUID> {
}

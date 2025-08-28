package com.projeto.financeiro.infrastructure.persistence.repository;

import com.projeto.financeiro.infrastructure.persistence.entity.DespesaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DespesaRepositoryAdapter extends JpaRepository<DespesaEntity, UUID> {
}

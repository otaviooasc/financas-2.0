package com.projeto.financeiro.infrastructure.repository;

import com.projeto.financeiro.infrastructure.entity.ReceitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReceitaRepositoryAdapter extends JpaRepository<ReceitaEntity, UUID> {
}

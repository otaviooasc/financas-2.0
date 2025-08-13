package com.projeto.financeiro.infrastructure.persistence.repository;

import com.projeto.financeiro.infrastructure.persistence.entity.ReceitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReceitaRepositoryAdapter extends JpaRepository<ReceitaEntity, UUID> {
}

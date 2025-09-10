package com.projeto.financeiro.infrastructure.persistence.repository;

import com.projeto.financeiro.infrastructure.persistence.entity.CarteiraMensalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarteiraJCRepositoryAdapter extends JpaRepository<CarteiraMensalEntity, UUID> {
    List<CarteiraMensalEntity> findBymesAnoCarteira(String mesAnoCarteira);
}

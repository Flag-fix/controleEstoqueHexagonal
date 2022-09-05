package com.controle.estoque.hexagonal.infraestrutura.adaptadores.repositories;

import com.controle.estoque.hexagonal.infraestrutura.adaptadores.entidades.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {
    Optional<ProdutoEntity> findById(UUID id);
}

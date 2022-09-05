package com.controle.estoque.hexagonal.dominio.portas.repositories;

import com.controle.estoque.hexagonal.dominio.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepositoryPort {
    List<Produto> buscarTodos();

    Optional<Produto> buscarPeloId(String id);

    void salvarProduto(Produto produto);
}

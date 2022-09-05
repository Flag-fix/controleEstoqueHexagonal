package com.controle.estoque.hexagonal.infraestrutura.adaptadores.repositories;

import com.controle.estoque.hexagonal.dominio.Produto;
import com.controle.estoque.hexagonal.dominio.portas.repositories.ProdutoRepositoryPort;
import com.controle.estoque.hexagonal.infraestrutura.adaptadores.entidades.ProdutoEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class ProdutoRepository implements ProdutoRepositoryPort {

    final SpringProdutoRepository springProdutoRepository;

    @Override
    public List<Produto> buscarTodos() {
        var produtoEntities = this.springProdutoRepository.findAll();
        return produtoEntities.stream().map(ProdutoEntity::toProduto).toList();
    }

    @Override
    public Optional<Produto> buscarPeloId(String id) {
        var produtoEntity = this.springProdutoRepository.findById(UUID.fromString(id));
        if (produtoEntity.isPresent())
            return Optional.ofNullable(produtoEntity.get().toProduto());
        throw new IllegalArgumentException("Produto não existe");
    }

    @Override
    public void salvarProduto(Produto produto) {
        ProdutoEntity produtoEntity;
        if (Objects.isNull(produto.getId()))
            produtoEntity = new ProdutoEntity(produto);
        else {
            produtoEntity = this.springProdutoRepository.findById(produto.getId()).orElse(null);
            assert produtoEntity != null;
            produtoEntity.atualizar(produto);
        }
        this.springProdutoRepository.save(produtoEntity);
    }
}

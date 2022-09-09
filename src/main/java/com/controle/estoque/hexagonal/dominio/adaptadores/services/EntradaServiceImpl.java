package com.controle.estoque.hexagonal.dominio.adaptadores.services;

import com.controle.estoque.hexagonal.dominio.Produto;
import com.controle.estoque.hexagonal.dominio.dtos.ProdutoDTO;
import com.controle.estoque.hexagonal.dominio.portas.interfaces.ProdutoServicePort;
import com.controle.estoque.hexagonal.dominio.portas.repositories.ProdutoRepositoryPort;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class EntradaServiceImpl implements ProdutoServicePort {

    final ProdutoRepositoryPort produtoRepository;

    @Override
    public void salvarProduto(ProdutoDTO produtoDTO) {
        var produto = new Produto(produtoDTO);
        this.produtoRepository.salvarProduto(produto);
    }

    @Override
    public List<ProdutoDTO> buscarProdutos() {
        var produtos = this.produtoRepository.buscarTodos();
        return produtos.stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
    }

    @Override
    public void atualizarEstoque(String id, Integer qtdEstoque) throws NotFoundException {
        var produto = Optional
                .ofNullable(this.produtoRepository.buscarPeloId(id)
                        .orElseThrow(() -> new NotFoundException("Produto não encontrado")));

        produto.orElse(null).atualizarEstoque(qtdEstoque);
        this.produtoRepository.salvarProduto(produto.get());
    }
}

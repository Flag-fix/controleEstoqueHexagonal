package com.controle.estoque.hexagonal.dominio.portas.interfaces;

import com.controle.estoque.hexagonal.dominio.Produto;
import com.controle.estoque.hexagonal.dominio.dtos.ProdutoDTO;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface ProdutoServicePort {

    List<ProdutoDTO> buscarProdutos();

    void salvarProduto(ProdutoDTO produtoDTO);

    void atualizarEstoque(String id, Integer qtdEstoque) throws NotFoundException;
}

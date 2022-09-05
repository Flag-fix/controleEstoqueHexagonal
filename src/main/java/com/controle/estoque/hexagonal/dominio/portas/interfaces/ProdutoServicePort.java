package com.controle.estoque.hexagonal.dominio.portas.interfaces;

import com.controle.estoque.hexagonal.dominio.dtos.ProdutoDTO;
import javassist.NotFoundException;

import java.util.List;

public interface ProdutoServicePort {

    List<ProdutoDTO> buscarProdutos();

    void salvarProduto(ProdutoDTO produtoDTO);

    void atualizarEstoque(String id, Double qtdEstoque) throws NotFoundException;
}

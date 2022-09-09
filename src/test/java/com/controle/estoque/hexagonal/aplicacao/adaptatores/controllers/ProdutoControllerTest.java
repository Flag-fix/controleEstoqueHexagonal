package com.controle.estoque.hexagonal.aplicacao.adaptatores.controllers;

import com.controle.estoque.hexagonal.dominio.Produto;
import com.controle.estoque.hexagonal.dominio.dtos.ProdutoDTO;
import com.controle.estoque.hexagonal.integration.TestRepositoryIT;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProdutoControllerTest extends TestRepositoryIT {

    @Autowired
    private ProdutoController controller;

    @Test
    public void produtoComValorErrado() {

        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome("Calça Jeans");
        produtoDTO.setQuantidade(1);

        controller.criarProduto(produtoDTO);
        var produto = super.findFirst(Produto.class);

        assertNotNull(produto);
        assertEquals(produtoDTO.getNome(), produto.getNome());
    }


}
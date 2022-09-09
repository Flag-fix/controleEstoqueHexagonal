package com.controle.estoque.hexagonal.aplicacao.adaptatores.controllers;

import com.controle.estoque.hexagonal.aplicacao.adaptatores.controllers.integracao.TestRepositoryIT;
import com.controle.estoque.hexagonal.dominio.Produto;
import com.controle.estoque.hexagonal.dominio.dtos.ProdutoDTO;
import lombok.AllArgsConstructor;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AllArgsConstructor
public class ProdutoControllerTest extends TestRepositoryIT {

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
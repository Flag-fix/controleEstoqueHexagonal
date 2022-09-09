package com.controle.estoque.hexagonal.aplicacao.adaptatores.controllers;

import com.controle.estoque.hexagonal.dominio.Produto;
import com.controle.estoque.hexagonal.dominio.dtos.ProdutoDTO;
import com.controle.estoque.hexagonal.infraestrutura.adaptadores.entidades.ProdutoEntity;
import com.controle.estoque.hexagonal.integration.TestRepositoryIT;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProdutoControllerTest extends TestRepositoryIT {

    @Autowired
    private ProdutoController controller;

    @Test
    public void produtoComValorErrado() {

        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome("Calça Jeans");
        produtoDTO.setQuantidade(10);
        produtoDTO.setPreco(-10.0);

        try {
            controller.criarProduto(produtoDTO);
        }catch (Exception e){
            assertEquals("criarProduto.produtoDTO.preco: O preço de um produto não pode ser negativo ou zero", e.getMessage());
        }
    }

    @Test
    public void criandoProduto() {

        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome("Calça Jeans");
        produtoDTO.setQuantidade(10);
        produtoDTO.setPreco(10.00);

        controller.criarProduto(produtoDTO);
        var produto = super.findFirst(ProdutoEntity.class);

        assertNotNull(produto);
        assertEquals(produtoDTO.getNome(), produto.getNome());
    }

//    @Test
//    public void validaProduto(){
//        Produto produto = new Produto();
//        produto.setNome("Calça Jeans");
//        produto.setQuantidade(1.0);
//        produto.setValorProduto(100.0);
//        produto.setId(UUID.randomUUID());
//
//        assertEquals(produto.getNome(),"Calça Jeans");
//        assertEquals(produto.getQuantidade().toString(), "1.0");
//        assertEquals(produto.getValorProduto().toString(),"100.0");
//    }
//
//    @Test
//    public void produtoComQuantidadeErrada (){
//        Produto produto = new Produto();
//        produto.setNome("Calça Jeans");
//        produto.setQuantidade(-1.0);
//        produto.setValorProduto(100.0);
//        produto.setId(UUID.randomUUID());
//
//        ProdutoDTO produtoDTO = produto.toProdutoDTO();
//
//
//
//
//
//    }


}
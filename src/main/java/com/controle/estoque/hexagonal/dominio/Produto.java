package com.controle.estoque.hexagonal.dominio;

import com.controle.estoque.hexagonal.dominio.dtos.ProdutoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class Produto {

    private UUID id;
    private String nome;
    private Double valorProduto;
    private Double quantidade;

    public Produto() {
    }

    public Produto(ProdutoDTO produtoDTO) {
        this.nome = produtoDTO.getNome();
        this.valorProduto = produtoDTO.getPreco();
        this.quantidade = produtoDTO.getQuantidade();
    }

    public void atualizarEstoque(double quantidade) {
        this.quantidade = quantidade;
    }

    public ProdutoDTO toProdutoDTO() {
        return new ProdutoDTO(this.nome, this.valorProduto, this.quantidade);
    }
}

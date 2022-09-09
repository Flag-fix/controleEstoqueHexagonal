package com.controle.estoque.hexagonal.infraestrutura.adaptadores.entidades;

import com.controle.estoque.hexagonal.dominio.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private Double valorProduto;
    private Integer quantidade;

    public ProdutoEntity() {
    }

    public ProdutoEntity(Produto produto) {
        this.nome = produto.getNome();
        this.valorProduto = produto.getValorProduto();
        this.quantidade = produto.getQuantidade();
    }

    public void atualizar(Produto produto) {
        this.nome = produto.getNome();
        this.valorProduto = produto.getValorProduto();
        this.quantidade = produto.getQuantidade();
    }

    public Produto toProduto() {
        return new Produto(this.id, this.nome, this.valorProduto,this.quantidade);
    }
}

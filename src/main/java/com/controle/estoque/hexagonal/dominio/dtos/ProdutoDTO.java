package com.controle.estoque.hexagonal.dominio.dtos;

import lombok.*;

@Data
@AllArgsConstructor
public class ProdutoDTO {

    private String nome;
    private Double preco;
    private Double quantidade;

}

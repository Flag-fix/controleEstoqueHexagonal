package com.controle.estoque.hexagonal.dominio.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    @Schema(
            example = "Pilha",
            description = "Identificação do nome do produto",
            required = true
    )
    @JsonProperty("nome")
    @NotEmpty(message = "Nome não pode ser nulo ou vazio")
    private String nome;

    @Schema(
            example = "50.00",
            description = "Identificação do preço do produto",
            required = true
    )
    @JsonProperty("preco")
    @NegativeOrZero(message = "O preço de um produto não pode ser negativo ou zero")
    private Double preco;

    @Schema(
            example = "10",
            description = "Identificação do quantidade do produto",
            required = true
    )
    @JsonProperty("quantidade")
    @NegativeOrZero(message = "A quantidade do produto não pode ser negativo ou zero")
    private Integer quantidade;
}

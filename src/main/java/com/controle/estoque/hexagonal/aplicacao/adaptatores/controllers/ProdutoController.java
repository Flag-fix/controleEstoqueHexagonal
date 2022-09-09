package com.controle.estoque.hexagonal.aplicacao.adaptatores.controllers;

import com.controle.estoque.hexagonal.dominio.dtos.ProdutoDTO;
import com.controle.estoque.hexagonal.dominio.portas.interfaces.ProdutoServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping("produto")
@Tag(name = "Produto", description = "Operação relacioada a persistencia de produtos")
public class ProdutoController {

    final ProdutoServicePort produtoServicePort;

    @Operation(description = "Salva Produto no banco de dados")
    @PostMapping
    ResponseEntity<Object> criarProduto(@RequestBody @Valid ProdutoDTO produtoDTO) {
        produtoServicePort.salvarProduto(produtoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    List<ProdutoDTO> getProdutos() {
        return produtoServicePort.buscarProdutos();
    }

    @PutMapping(value = "/{id}")
    void atualizarEstoque(@PathVariable String id, @RequestBody Integer qtdEstoque) throws NotFoundException {
        produtoServicePort.atualizarEstoque(id, qtdEstoque);
    }
}

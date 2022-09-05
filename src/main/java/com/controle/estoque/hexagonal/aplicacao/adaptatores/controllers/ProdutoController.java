package com.controle.estoque.hexagonal.aplicacao.adaptatores.controllers;

import com.controle.estoque.hexagonal.dominio.dtos.ProdutoDTO;
import com.controle.estoque.hexagonal.dominio.portas.interfaces.ProdutoServicePort;
import io.swagger.v3.oas.annotations.tags.Tag;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("produto")
@Tag(name = "Produto", description = "Operação relacioada a persistencia de produtos")
public class ProdutoController {

    final ProdutoServicePort produtoServicePort;

    @PostMapping
    void criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        produtoServicePort.salvarProduto(produtoDTO);
    }

    @GetMapping
    List<ProdutoDTO> getProdutos() {
        return produtoServicePort.buscarProdutos();
    }

    @PutMapping(value = "/{id}")
    void atualizarEstoque(@PathVariable String id, @RequestBody Double qtdEstoque) throws NotFoundException {
        produtoServicePort.atualizarEstoque(id, qtdEstoque);
    }
}

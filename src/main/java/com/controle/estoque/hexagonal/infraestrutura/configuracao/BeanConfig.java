package com.controle.estoque.hexagonal.infraestrutura.configuracao;

import com.controle.estoque.hexagonal.dominio.portas.interfaces.ProdutoServicePort;
import com.controle.estoque.hexagonal.dominio.adaptadores.services.EntradaServiceImpl;
import com.controle.estoque.hexagonal.dominio.portas.repositories.ProdutoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    ProdutoServicePort produtoService(ProdutoRepositoryPort produtoRepositoryPort) {
        return new EntradaServiceImpl(produtoRepositoryPort);
    }
}

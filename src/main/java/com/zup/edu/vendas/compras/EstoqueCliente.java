package com.zup.edu.vendas.compras;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "abacaxi", url = "${feign.client.config.estoque.url}")
public interface EstoqueCliente {

    @CircuitBreaker(name = "", fallbackMethod = "fallback")
    @GetMapping("/produtos/{id}")
    public Produto getProduto(@PathVariable int id);

    @PostMapping("/produtos")
    public void insertProduto(@RequestBody Produto produto);
}

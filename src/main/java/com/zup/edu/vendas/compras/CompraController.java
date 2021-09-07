package com.zup.edu.vendas.compras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    EstoqueCliente estoqueCliente;

    @PostMapping
    public Compra insert(@RequestBody Compra compra){

        //Cliente da api externa
        Produto produto = estoqueCliente.getProduto(compra.getCodigoProduto());

        if(produto.possuiEstoque()){
            //registra a compra e faz os próximos passos
            compra.setId(12545);
        }

        return compra;
    }
}

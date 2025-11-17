package com.projetosoftwareteusz.teusz.pedido;

import com.projetosoftwareteusz.teusz.entities.Pedido;

public class PedidoExpresso implements IPedido { // 1. Implementa a interface

    @Override
    public void processarPedido(Pedido pedido) {

        System.out.println("Processando Pedido EXPRESSO (ID: " + pedido.getId() + ")");
        System.out.println("Sem desconto. Aplicando taxa de urgência.");
        
    }

}

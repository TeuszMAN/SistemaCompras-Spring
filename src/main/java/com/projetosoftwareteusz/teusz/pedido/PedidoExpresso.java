package com.projetosoftwareteusz.teusz.pedido;

public class PedidoExpresso implements IPedido {

    @Override
    public void processarPedido() {
        // Lógica específica para processar um pedido expresso
        System.out.println("Processando pedido expresso...");
    }

}

package com.projetosoftwareteusz.teusz.pedido;

import com.projetosoftwareteusz.teusz.config.ConfiguracaoSistema;
import com.projetosoftwareteusz.teusz.entities.Pedido;

public class PedidoComum implements IPedido {

    @Override
    public void processarPedido(Pedido pedido) {
        
        ConfiguracaoSistema config = ConfiguracaoSistema.INSTANCIA; 
        
        
        double desconto = config.getTaxaDescontoGlobal();
        
        System.out.println("Processando Pedido COMUM (ID: " + pedido.getId() + ")");
        System.out.println("Aplicando desconto de: " + (desconto * 100) + "%");

    }
}

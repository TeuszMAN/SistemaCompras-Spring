package com.projetosoftwareteusz.teusz.factory;

import com.projetosoftwareteusz.teusz.entities.TipoPedido;
import com.projetosoftwareteusz.teusz.pedido.IPedido;
import com.projetosoftwareteusz.teusz.pedido.PedidoComum;
import com.projetosoftwareteusz.teusz.pedido.PedidoExpresso;
import org.springframework.stereotype.Component;

@Component
public class PedidoFactory {


    public IPedido criarPedido(TipoPedido tipo) {
        if (tipo == TipoPedido.COMUM) {
            return new PedidoComum();
        } else if (tipo == TipoPedido.EXPRESSO) {
            return new PedidoExpresso();
        }
        throw new IllegalArgumentException("Tipo de pedido desconhecido: " + tipo);
    }

}

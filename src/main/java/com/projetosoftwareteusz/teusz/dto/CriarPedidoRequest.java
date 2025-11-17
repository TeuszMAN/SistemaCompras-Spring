package com.projetosoftwareteusz.teusz.dto;

import java.util.List;

import com.projetosoftwareteusz.teusz.entities.ItemPedido;
import com.projetosoftwareteusz.teusz.entities.TipoPedido;

public class CriarPedidoRequest {

    private TipoPedido tipo;
    private List<ItemPedido> itens;

    public TipoPedido getTipo() {
        return tipo;
    }

    public void setTipo(TipoPedido tipo) {
        this.tipo = tipo;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }


}

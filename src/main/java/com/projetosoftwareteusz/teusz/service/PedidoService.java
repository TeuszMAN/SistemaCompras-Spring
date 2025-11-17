package com.projetosoftwareteusz.teusz.service;

import com.projetosoftwareteusz.teusz.Logistica.LogisticaAdapter;
import com.projetosoftwareteusz.teusz.factory.PedidoFactory;

public class PedidoService {

    private final PedidoFactory pedidoFactory;
    private final LogisticaAdapter logisticaAdapter;

    public PedidoService(PedidoFactory pedidoFactory, LogisticaAdapter logisticaAdapter) {
        this.pedidoFactory = pedidoFactory;
        this.logisticaAdapter = logisticaAdapter;
    }

}

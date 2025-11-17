package com.projetosoftwareteusz.teusz.Logistica;

import com.projetosoftwareteusz.teusz.entities.Pedido;
import com.projetosoftwareteusz.teusz.entities.StatusPedido;

public class LogisticaAdapter implements ILogistica {

    private final ILogisticaLegado logisticaLegado;

    public LogisticaAdapter(ILogisticaLegado logisticaLegado) {
        this.logisticaLegado = logisticaLegado;
    }

    @Override
    public void enviar(Pedido pedido) {
        logisticaLegado.enviarPacote("Rua das flores, 121", "Pedido ID: " + pedido.getId());
        pedido.setStatus(StatusPedido.PRONTO);
    }

}

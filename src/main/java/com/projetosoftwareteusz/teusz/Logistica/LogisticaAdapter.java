package com.projetosoftwareteusz.teusz.Logistica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projetosoftwareteusz.teusz.entities.Pedido;
import com.projetosoftwareteusz.teusz.entities.StatusPedido;

@Component
public class LogisticaAdapter implements ILogistica {

    private final ILogisticaLegado logisticaLegado;

    @Autowired
    public LogisticaAdapter(ILogisticaLegado logisticaLegado) {
        this.logisticaLegado = logisticaLegado;
    }

    @Override
    public void enviar(Pedido pedido) {
        logisticaLegado.enviarPacote("Rua das flores, 121", "Pedido ID: " + pedido.getId());
    }

}

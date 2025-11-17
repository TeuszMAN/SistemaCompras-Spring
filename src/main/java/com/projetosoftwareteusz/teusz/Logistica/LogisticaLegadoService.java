package com.projetosoftwareteusz.teusz.Logistica;

import org.springframework.stereotype.Service;

@Service
public class LogisticaLegadoService implements ILogisticaLegado {

    @Override
    public void enviarPacote(String endereco, String codigoRastreio) {
        System.out.println("SERVICE LEGADO:");
        System.out.println("Enviando pacote para " + endereco + " com código de rastreio " + codigoRastreio);
    }

}

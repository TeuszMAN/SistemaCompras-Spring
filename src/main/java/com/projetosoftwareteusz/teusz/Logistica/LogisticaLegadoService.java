package com.projetosoftwareteusz.teusz.Logistica;

public class LogisticaLegadoService implements ILogisticaLegado {

    @Override
    public void enviarPacote(String endereco, String codigoRastreio) {
        System.out.println("Enviando pacote para " + endereco + " com código de rastreio " + codigoRastreio);
    }

}

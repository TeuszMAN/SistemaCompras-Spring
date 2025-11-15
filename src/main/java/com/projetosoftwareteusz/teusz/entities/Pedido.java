package com.projetosoftwareteusz.teusz.entities;

import java.sql.Date;
import java.util.List;

public class Pedido {

    private int id;
    private Date dataCriacao;
    private StatusPedido status;
    private List<Produto> itens;


    public Pedido(int id, Date dataCriacao, StatusPedido status, List<Produto> itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.itens = itens;
    }

    public int getId() {
        return id;
    }
    public Date getDataCriacao() {
        return dataCriacao;
    }
    public StatusPedido getStatus() {
        return status;
    }
    public List<Produto> getItens() {
        return itens;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void setItens(List<Produto> itens) {
        this.itens = itens;
    }
    
    public String toString() {
        return "Pedido{id=" + id + ", dataCriacao=" + dataCriacao + ", status=" + status + ", itens=" + itens + "}";
    }

}

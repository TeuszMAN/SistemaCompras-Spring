package com.projetosoftwareteusz.teusz.entities;

import java.util.Date; 
import java.util.List;


import jakarta.persistence.*;

@Entity // 3. Avisa ao JPA que esta classe é uma tabela
@Table(name = "pedidos") 
public class Pedido {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id; 

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Enumerated(EnumType.STRING) 
    private StatusPedido status;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id") 
    private List<ItemPedido> itens;

    public Pedido() {
    }


    public Pedido(Integer id, Date dataCriacao, StatusPedido status, List<ItemPedido> itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.itens = itens;
    }

  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Pedido{id=" + id + ", dataCriacao=" + dataCriacao + ", status=" + status + ", itens=" + itens + "}";
    }
}
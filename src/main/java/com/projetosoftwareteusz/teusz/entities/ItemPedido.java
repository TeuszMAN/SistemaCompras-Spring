package com.projetosoftwareteusz.teusz.entities;

public class ItemPedido {

    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return produto.getPreco() * quantidade;
    }
    
    public String toString() {
        return "ItemPedido{produto=" + produto + ", quantidade=" + quantidade + "}";
    }


}

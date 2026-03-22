package org.example.decorator;

public class PedidoDecorator implements ItemPedido{

    protected ItemPedido itempedido;

    public ItemPedido(ItemPedido itempedido){
        this.itempedido = itempedido;
    }
}

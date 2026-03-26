package org.example.decorator;

public abstract class PedidoDecorator implements ItemPedido{

    protected ItemPedido itempedido;

    public PedidoDecorator(ItemPedido itempedido){
        this.itempedido = itempedido;
    }

    @Override
    public double getPreco() {
        return itempedido.getPreco();
    }

    @Override
    public String getDescricao() {
        return itempedido.getDescricao();
    }
}

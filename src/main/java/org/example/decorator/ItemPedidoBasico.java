package org.example.decorator;

public class ItemPedidoBasico implements ItemPedido {
    @Override
    public String getDescricao(){
        return "Produto básico";
    }

    @Override
    public double getPreco(){
        return 1.0;
    }
}

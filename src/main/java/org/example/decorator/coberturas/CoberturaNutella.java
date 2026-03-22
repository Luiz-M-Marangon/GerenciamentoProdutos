package org.example.decorator.coberturas;

import org.example.decorator.ItemPedido;
import org.example.decorator.PedidoDecorator;

public class CoberturaNutella extends PedidoDecorator {
    public CoberturaNutella(ItemPedido itempedido){
        super(itempedido);
    }

    @Override
    public String getDescricao(){
        return itempedido.getDescricao() + "Cobertura nutella";
    }

    @Override
    public double getPreco(){
        return itempedido.getPreco() + 4;
    }
}

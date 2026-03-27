package org.example.decorator.coberturas;

import org.example.decorator.ItemPedido;
import org.example.decorator.PedidoDecorator;

public class CoberturaNutella extends PedidoDecorator {

    private static double preco = 4.0;

    public static void setPreco(double preco) {
        CoberturaNutella.preco = preco;
    }

    public CoberturaNutella(ItemPedido itempedido){
        super(itempedido);
    }

    @Override
    public String getDescricao(){
        return itempedido.getDescricao() + "Cobertura nutella\n";
    }

    @Override
    public double getPreco(){
        return itempedido.getPreco() + preco;
    }
}

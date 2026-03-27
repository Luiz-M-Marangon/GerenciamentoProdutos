package org.example.decorator.coberturas;

import org.example.decorator.ItemPedido;
import org.example.decorator.PedidoDecorator;

public class CoberturaNinho extends PedidoDecorator {

    public static double preco = 3.5;

    public static void setPreco(double preco) {
        CoberturaNinho.preco = preco;
    }

    public CoberturaNinho(ItemPedido itempedido){
        super(itempedido);
    }

    @Override
    public String getDescricao(){
        return itempedido.getDescricao() + "Cobertura leite ninho";
    }

    @Override
    public double getPreco(){
        return itempedido.getPreco() + preco;
    }
}

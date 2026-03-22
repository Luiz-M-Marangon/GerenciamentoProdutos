package org.example.pagamento.adapter;

import org.example.pagamento.adaptee.CartaoVA;

public class CartaoVAAdapter implements ProcessoPagamento{

    private CartaoVA cartaova;

    public CartaoVAAdapter(CartaoVA cartaova){
        this.cartaova = cartaova;
    }

    @Override
    public void pagar(double valor){
        cartaova.pagamentototal(valor);
    }
}

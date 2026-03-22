package org.example.pagamento.adapter;

import org.example.pagamento.adaptee.PayPal;

public class PayPalAdapter implements ProcessoPagamento{

    private PayPal paypal;

    public PayPalAdapter(PayPal paypal){
        this.paypal = paypal;
    }

    @Override
    public void pagar(double valor){
        paypal.sendPaymet(valor);
    }
}

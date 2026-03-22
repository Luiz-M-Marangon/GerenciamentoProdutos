package org.example.pagamento;

import org.example.pagamento.adapter.ProcessoPagamento;

public class CartaoCredito implements ProcessoPagamento {

    @Override
    public void pagar(double valor){
        System.out.println("Pagamento realizado no crédito no valor de: R$: " + valor);
    }
}

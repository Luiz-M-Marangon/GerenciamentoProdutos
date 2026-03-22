package org.example.pagamento;

import org.example.pagamento.adapter.ProcessoPagamento;

public class CartaoDebito implements ProcessoPagamento {

    public void pagar(double valor){
        System.out.println("Pagamento via débito no valor de: R$" + valor);
    }
}

package org.example.pagamento.adaptee;

public class PayPal {

    public void sendPaymet(double total){
        System.out.println("Pagamento via PIX: R$" + total);
    }
}

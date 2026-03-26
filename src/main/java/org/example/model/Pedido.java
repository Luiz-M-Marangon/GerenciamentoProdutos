package org.example.model;

import java.util.ArrayList;
import java.util.List;

import org.example.decorator.ItemPedido;
import org.example.observer.Observer;
import org.example.pagamento.adapter.ProcessoPagamento;


//CLASSE USADA PARA LINKAR TODOS AS PONTAS DO SISTEMA EM UM SÓ LOCAL
public class Pedido {

    private List<ItemPedido> itens;
    private List<Observer> observers;
    private ProcessoPagamento pagamento;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    // -------------------------
    // ITENS DO PEDIDO
    // -------------------------
    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public void removerItem(ItemPedido item) {
        itens.remove(item);
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    // -------------------------
    // CÁLCULO TOTAL
    // -------------------------
    public double calcularTotal() {
        return itens.stream()
                .mapToDouble(ItemPedido::getPreco)
                .sum();
    }

    // -------------------------
    // OBSERVER (notificações)
    // -------------------------
    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notificarObservers(String mensagem) {
        for (Observer o : observers) {
            o.update(mensagem);
        }
    }

    // -------------------------
    // PAGAMENTO (Adapter)
    // -------------------------
    public void setPagamento(ProcessoPagamento pagamento) {
        this.pagamento = pagamento;
    }

    // -------------------------
    // FINALIZAÇÃO DO PEDIDO
    // -------------------------
    public void finalizarPedido() {
        double total = calcularTotal();

        if (pagamento == null) {
            throw new RuntimeException("Forma de pagamento não definida!");
        }

        pagamento.pagar(total);

        notificarObservers("Pedido finalizado! Total: R$ " + total);
    }
}
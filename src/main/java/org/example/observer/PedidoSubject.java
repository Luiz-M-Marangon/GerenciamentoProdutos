package org.example.observer;

import java.util.ArrayList;
import java.util.List;

public class PedidoSubject implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private String status;
    private int id;

    public PedidoSubject(int id){
        this.id = id;
    }

    public void setStatus(String status){
        this.status = status;
        notifyObservers();
    }

    public String getStatus(){
        return status;
    }

    @Override
    public void addObserver(Observer o){
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o){observers.remove(o);}

    @Override
    public void notifyObservers(){
        for (Observer o : observers){
            o.update("Pedido #" + id + " atualizado para " + status);
        }
    }
}

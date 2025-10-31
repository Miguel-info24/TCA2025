package com.miguel.vannucci.models;

import java.time.LocalDate;

public class Pagamento {
    private String id;
    private double valor;
    private String metodo;
    private LocalDate dataPagamento;

    public Pagamento(String id, double valor, String metodo, LocalDate dataPagamento) {
        this.id = id;
        this.valor = valor;
        this.metodo = metodo;
        this.dataPagamento = dataPagamento;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", metodo='" + metodo + '\'' +
                ", dataPagamento=" + dataPagamento +
                '}';
    }
}

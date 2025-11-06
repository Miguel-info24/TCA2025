package com.miguel.vannucci.models;

import java.time.LocalDate;

public class Pedido {
    private int id;
    private int idUser;
    private String descricao;
    private double preco;
    private String status;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Barco barco;

    public Pedido(int id, int idUser, String descricao, double preco,
                  String status, LocalDate dataInicio, LocalDate dataFim, Barco barco) {
        this.id = id;
        this.idUser = idUser;
        this.descricao = descricao;
        this.preco = preco;
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.barco = barco;
    }

    public int getId() { return id; }
    public int getIdUser() { return idUser; }
    public String getDescricao() { return descricao; }
    public double getPreco() { return preco; }
    public String getStatus() { return status; }
    public LocalDate getDataInicio() { return dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public Barco getBarco() { return barco; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Pedido{" +
                "id='" + id + '\'' +
                ", idUser=" + idUser +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", status='" + status + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", barco=" + barco +
                '}';
    }
}

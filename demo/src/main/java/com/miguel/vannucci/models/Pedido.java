package com.miguel.vannucci.models;

import java.time.LocalDate;

public class Pedido {
    private int id;                  // PK
    private int idUser;              // FK -> User
    private Integer idBarcoMolde;    // FK -> Barco (pode ser nulo se for personalizado)
    private String barcoPersonalizado; // Nome do barco se o cliente descreveu manualmente
    private String descricao;        // Descrição do pedido (detalhes adicionais)
    private double preco;            // Definido pelo carpinteiro
    private String status;           // Ex: "Em análise", "Em produção", "Concluído"
    private LocalDate dataInicio;    
    private LocalDate dataFim;
    
    // Campo auxiliar (não vai pro BD) — serve para exibir o nome correto no dashboard
    private String barcoEscolhido;   

    // 🔹 Construtor principal
    public Pedido(int id, int idUser, Integer idBarcoMolde, String barcoPersonalizado,
                  String descricao, double preco, String status,
                  LocalDate dataInicio, LocalDate dataFim) {
        this.id = id;
        this.idUser = idUser;
        this.idBarcoMolde = idBarcoMolde;
        this.barcoPersonalizado = barcoPersonalizado;
        this.descricao = descricao;
        this.preco = preco;
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // 🔹 Getters e setters
    public int getId() { return id; }
    public int getIdUser() { return idUser; }
    public Integer getIdBarcoMolde() { return idBarcoMolde; }
    public String getBarcoPersonalizado() { return barcoPersonalizado; }
    public String getDescricao() { return descricao; }
    public double getPreco() { return preco; }
    public String getStatus() { return status; }
    public LocalDate getDataInicio() { return dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public String getBarcoEscolhido() { return barcoEscolhido; }

    public void setId(int id) { this.id = id; }
    public void setIdUser(int idUser) { this.idUser = idUser; }
    public void setIdBarcoMolde(Integer idBarcoMolde) { this.idBarcoMolde = idBarcoMolde; }
    public void setBarcoPersonalizado(String barcoPersonalizado) { this.barcoPersonalizado = barcoPersonalizado; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setPreco(double preco) { this.preco = preco; }
    public void setStatus(String status) { this.status = status; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }
    public void setBarcoEscolhido(String barcoEscolhido) { this.barcoEscolhido = barcoEscolhido; }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idBarcoMolde=" + idBarcoMolde +
                ", barcoPersonalizado='" + barcoPersonalizado + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", status='" + status + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                '}';
    }
}

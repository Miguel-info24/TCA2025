package com.miguel.vannucci.models;

public class Barco {
    private String id;
    private String nome;
    private String tipo; // Pesca, Passeio, Transporte
    private double tamanho;
    private String material;

    public Barco(String id, String nome, String tipo, double tamanho, String material) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.tamanho = tamanho;
        this.material = material;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }    
    public String getTipo() { return tipo; }
    public double getTamanho() { return tamanho; }
    public String getMaterial() { return material; }

    public void setNome(String nome) { this.nome = nome; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setTamanho(double tamanho) { this.tamanho = tamanho; }
    public void setMaterial(String material) { this.material = material; }

    @Override
    public String toString() {
        return "Barco{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", tamanho=" + tamanho +
                ", material='" + material + '\'' +
                '}';
    }
}

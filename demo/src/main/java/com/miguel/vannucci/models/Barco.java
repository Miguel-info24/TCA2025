package com.miguel.vannucci.models;

public class Barco {
    private int id;
    private String nome;
    private String tipo; // Pesca, Passeio, Transporte
    private String cor;
    private double tamanho;
    private String material;

    public Barco(int id, String nome, String tipo, String cor, double tamanho, String material) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.cor = cor;
        this.tamanho = tamanho;
        this.material = material;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }    
    public String getTipo() { return tipo; }
    public String getCor() { return cor; }
    public double getTamanho() { return tamanho; }
    public String getMaterial() { return material; }

    public void setNome(String nome) { this.nome = nome; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setCor(String cor) { this.cor = cor; }
    public void setTamanho(double tamanho) { this.tamanho = tamanho; }
    public void setMaterial(String material) { this.material = material; }

    @Override
    public String toString() {
        return "Barco{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", cor='" + cor + '\'' +
                ", tamanho=" + tamanho +
                ", material='" + material + '\'' +
                '}';
    }
}

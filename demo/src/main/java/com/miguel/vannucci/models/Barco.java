package com.miguel.vannucci.models;

public class Barco {
    private int idBarco;          // PK
    private String nomeBarco;     // Ex: "Barco de pesca pequeno"
    private String tipoBarco;     // Ex: "Pesca", "Passeio", "Transporte"
    private String materialBarco; // Ex: "Madeira", "Fibra de vidro"

    // 🔹 Construtores
    public Barco(int idBarco, String nomeBarco, String tipoBarco, String materialBarco) {
        this.idBarco = idBarco;
        this.nomeBarco = nomeBarco;
        this.tipoBarco = tipoBarco;
        this.materialBarco = materialBarco;
    }

    public Barco(String nomeBarco, String tipoBarco, String materialBarco) {
        this.nomeBarco = nomeBarco;
        this.tipoBarco = tipoBarco;
        this.materialBarco = materialBarco;
    }

    // 🔹 Getters
    public int getIdBarco() { return idBarco; }
    public String getNomeBarco() { return nomeBarco; }
    public String getTipoBarco() { return tipoBarco; }
    public String getMaterialBarco() { return materialBarco; }

    // 🔹 Setters
    public void setIdBarco(int idBarco) { this.idBarco = idBarco; }
    public void setNomeBarco(String nomeBarco) { this.nomeBarco = nomeBarco; }
    public void setTipoBarco(String tipoBarco) { this.tipoBarco = tipoBarco; }
    public void setMaterialBarco(String materialBarco) { this.materialBarco = materialBarco; }

    @Override
    public String toString() {
        return "Barco{" +
                "idBarco=" + idBarco +
                ", nomeBarco='" + nomeBarco + '\'' +
                ", tipoBarco='" + tipoBarco + '\'' +
                ", materialBarco='" + materialBarco + '\'' +
                '}';
    }
}

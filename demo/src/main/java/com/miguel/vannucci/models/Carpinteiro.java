package com.miguel.vannucci.models;

import java.util.ArrayList;
import java.util.List;

public class Carpinteiro extends User {
    private List<Pedido> trabalhos = new ArrayList<>();

    public Carpinteiro(String name, String email, String password, String cpf, String phone) {
        super(name, email, password, cpf, phone, "carpinteiro");
    }

    public List<Pedido> getTrabalhos() { return trabalhos; }
    public void addTrabalho(Pedido pedido) { trabalhos.add(pedido); }

    @Override
    public String toString() {
        return "Carpinteiro{" +
                "trabalhos=" + trabalhos +
                "} " + super.toString();
    }
}

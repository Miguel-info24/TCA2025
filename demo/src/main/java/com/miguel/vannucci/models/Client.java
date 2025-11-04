package com.miguel.vannucci.models;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {
    private List<Pedido> pedidos = new ArrayList<>();

    public Client( String name, String email, String password, String cpf, String phone) {
        super(name, email, password, cpf, phone, "cliente");
    }
    public Client() {
        super();
    }

    public List<Pedido> getPedidos() { return pedidos; }
    public void addPedido(Pedido pedido) { pedidos.add(pedido); }

    @Override
    public String toString() {
        return "Client{" +
                "pedidos=" + pedidos +
                "} " + super.toString();
    }
}

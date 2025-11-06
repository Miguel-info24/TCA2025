package com.miguel.vannucci.models.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.miguel.vannucci.models.Pedido;

public interface pedidoDAO {

    int addPedido(int idUser, String descricao, double preco, String status, LocalDate dataInicio, LocalDate dataFim, int idBarco);

    boolean deletePedido(int idPedido);

    boolean updatePedido(int id, String descricao, double preco, String status, LocalDate dataInicio, LocalDate dataFim);

    List<Pedido> getPedidos();

    Pedido getPedidoById(int idPedido);

    List<Pedido> getPedidosByUserId(int idUser);

    int getIdUser();

    int getNextId();
}

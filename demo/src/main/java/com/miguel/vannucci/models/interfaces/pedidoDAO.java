package com.miguel.vannucci.models.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.miguel.vannucci.models.Pedido;

public interface pedidoDAO {

    int addPedido(int idUser, String descricao, double preco, String status, java.time.LocalDate dataInicio, java.time.LocalDate dataFim, Integer idBarco,String tamanhoPedido, String corPedido, String barcoPersonalizado);

    boolean deletePedido(int idPedido);

    boolean cancelarPedido(int idPedido);   

    boolean updatePedido(int id, String descricao, double preco, String status, LocalDate dataInicio, LocalDate dataFim);

    List<Pedido> getPedidos();

    Pedido getPedidoById(int idPedido);

    List<Pedido> getPedidosByUserId(int idUser);

    int getIdUser();

    int getNextId();
}

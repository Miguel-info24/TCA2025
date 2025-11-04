package com.miguel.vannucci.models.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.miguel.vannucci.models.Pedido;

public interface pedidoDAO {
    int addPedido(int id, String descricao, double preco,  String status, LocalDate dataInicio, LocalDate dataFim);
    boolean deletePedido(int idPedido); 
    boolean updatePedido(int id, String descricao, double preco, String status, LocalDate dataInicio, LocalDate dataFim);
    List<Pedido> getPedidos();
    Pedido getPedidoById(int idPedido);
    List<Pedido> getPedidosByClient(int idClient);
    List<Pedido> getPedidosByCarpinteiro(int idCarpinteiro);
}

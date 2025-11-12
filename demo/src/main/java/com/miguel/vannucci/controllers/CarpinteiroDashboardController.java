package com.miguel.vannucci.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.miguel.vannucci.models.Pedido;
import com.miguel.vannucci.models.User;
import com.miguel.vannucci.models.interfaces.UserDAO;
import com.miguel.vannucci.models.interfaces.pedidoDAO;

import io.javalin.http.Handler;

public class CarpinteiroDashboardController {

    public Handler get = ctx -> {
        pedidoDAO pedidoDAO = new com.miguel.vannucci.DAOs.DAOsPedidoImpl();
        UserDAO UserDAO = new com.miguel.vannucci.DAOs.DAOsUsersImpl();
        User currentUser = ctx.sessionAttribute("currentUser");
        if (currentUser == null) {
            ctx.redirect("/");
            return;
        }

        List<Pedido> pedidos = pedidoDAO.getPedidos(); 
        List<Map<String, Object>> pedidosComUser = new ArrayList<>();

        for (Pedido p : pedidos) {
            User cliente = UserDAO.getUserById(p.getIdUser());
            Map<String, Object> item = new HashMap<>();
            item.put("pedido", p);
            item.put("cliente", cliente);
            System.out.println("pedido id: " + p.getId());
            System.out.println("user id: " + p.getIdUser());
            System.out.println("cliente nome: " + cliente.getName());
            System.out.println("cliente email: " + cliente.getEmail());
            pedidosComUser.add(item);
        }

        Map<String, Object> model = new HashMap<>();
        model.put("name", currentUser.getName());
        model.put("pedidosComUser", pedidosComUser);

        ctx.render("carpinteiro_Dashboard.ftl", model);
    };

    public Handler atualizar = ctx -> {
        ctx.render("carpinteiro_Atualizar.ftl");
    };
}

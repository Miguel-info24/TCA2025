package com.miguel.vannucci.controllers;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import com.miguel.vannucci.models.Barco;

import com.miguel.vannucci.models.User;

import io.javalin.http.Handler;

public class ClienteDashboardController {

    public Handler get = ctx -> {
        User currentUser = ctx.sessionAttribute("currentUser");
        if (currentUser == null) {
            ctx.redirect("/");
            return;
        }
        else if (!currentUser.getType().equals("cliente")) {
            ctx.redirect("/carpinteiro_Dashboard");
            return;
        }
        else{
            Map<String, Object> model = new HashMap<>();
            model.put("name", currentUser.getName());
            model.put("email", currentUser.getEmail());

            ctx.render("cliente_dashBoard.ftl", model);
        }

        
    };

    public Handler fazerPedido = ctx -> {
        ctx.render("cliente_fazerPedido.ftl");

        int id = Integer.parseInt(ctx.formParam("id"));
        String descricao = ctx.formParam("descricao");
        double preco = Double.parseDouble(ctx.formParam("preco"));
        String status = ctx.formParam("status");
        LocalDate dataInicio = LocalDate.parse(ctx.formParam("dataInicio"));
        LocalDate dataFim = LocalDate.parse(ctx.formParam("dataFim"));
        Barco barco = SQLgetBarco();
    };

    public Handler cancelarPedido = ctx -> {
        ctx.render("cliente_cancelarPedido.ftl");
    };

    public Barco SQLgetBarco() {
        return null; 
    }
}

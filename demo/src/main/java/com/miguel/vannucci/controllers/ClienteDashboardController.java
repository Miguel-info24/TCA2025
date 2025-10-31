package com.miguel.vannucci.controllers;

import java.util.HashMap;
import java.util.Map;

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
    };

    public Handler cancelarPedido = ctx -> {
        ctx.render("cliente_cancelarPedido.ftl");
    };
}

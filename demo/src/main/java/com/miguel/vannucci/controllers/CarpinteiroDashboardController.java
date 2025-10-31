package com.miguel.vannucci.controllers;

import java.util.HashMap;
import java.util.Map;

import com.miguel.vannucci.models.User;

import io.javalin.http.Handler;

public class CarpinteiroDashboardController {
    public Handler get = ctx -> {
        User currentUser = ctx.sessionAttribute("currentUser");
        if (currentUser == null) {
            ctx.redirect("/");
            return;
        }
        else if (!currentUser.getType().equals("carpinteiro")) {
            ctx.redirect("/cliente_Dashboard");
            return;
        }
        else{
            Map<String, Object> model = new HashMap<>();
            model.put("name", currentUser.getName());
            model.put("email", currentUser.getEmail());
            ctx.render("carpinteiro_Dashboard.ftl", model);
        }
        
    };
    public Handler atualizar = ctx -> {
        ctx.render("carpinteiro_Atualizar.ftl");
    };
}

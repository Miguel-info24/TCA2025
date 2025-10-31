package com.miguel.vannucci.controllers;



import com.miguel.vannucci.DAOs.DAOsUsersImpl;
import com.miguel.vannucci.models.User;

import io.javalin.http.Handler;

public class LoginController {

    private final DAOsUsersImpl userDAO = new DAOsUsersImpl();
    public Handler get = ctx -> {
        ctx.render("index.ftl");
    };

    public Handler post = ctx -> {
        String email = ctx.formParam("email");
        System.out.println("form email" + email);
        String password = ctx.formParam("senha");
        System.out.println("form password" + password);

        User user = userDAO.getUserByEmailAndPassword(email, password);
        System.out.println("userDAO: " + user.getEmail() + ", " + user.getPassword() + ", " + user.getType());

        ctx.sessionAttribute("currentUser", user);

        if (user != null) {

            if ("cliente".equals(user.getType())) {
                ctx.redirect("/cliente_Dashboard");
            } else if ("carpinteiro".equals(user.getType())) {
                ctx.redirect("/carpinteiro_Dashboard");
            } else {
                ctx.status(400).result("Tipo de usuário inválido");
            }
       } else {
          ctx.status(401).result("E-mail ou senha incorretos");
       }
    };
}

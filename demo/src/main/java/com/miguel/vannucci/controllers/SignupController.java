package com.miguel.vannucci.controllers;

import com.miguel.vannucci.DAOs.DAOsUsersImpl;
import com.miguel.vannucci.models.Carpinteiro;
import com.miguel.vannucci.models.Client;
import com.miguel.vannucci.models.User;

import io.javalin.http.Handler;

public class SignupController {

    public Handler get = ctx -> {
        ctx.render("signup.ftl");
    };

    public Handler post = ctx -> {
        String name = ctx.formParam("name");
        System.out.println("form name" + name);
        String email = ctx.formParam("email");
        System.out.println("form email" + email);
        String password = ctx.formParam("password");
        System.out.println("form password" + password);
        String cpf = ctx.formParam("cpf");
        System.out.println("form cpf" + cpf);
        String phone = ctx.formParam("phone");
        System.out.println("form phone" + phone);
        String tipoUsuario = ctx.formParam("tipo");
        

        User novo;
        if ("carpinteiro".equalsIgnoreCase(tipoUsuario)) {
            novo = new Carpinteiro(name, email, password, cpf, phone);

        } else {
            novo = new Client(name, email, password, cpf, phone);
        } 
        
        DAOsUsersImpl userDAO = new DAOsUsersImpl();
        int resultado = userDAO.addUser(novo);
        ctx.redirect("/"); 
        System.out.println("Recebido: " + name + ", " + email + ", " + password + ", " + cpf + ", " + phone + ", " + tipoUsuario);
        
    };
}

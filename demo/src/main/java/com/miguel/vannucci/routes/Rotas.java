package com.miguel.vannucci.routes;

import com.miguel.vannucci.controllers.CarpinteiroDashboardController;
import com.miguel.vannucci.controllers.ClienteDashboardController;
import com.miguel.vannucci.controllers.LoginController;
import com.miguel.vannucci.controllers.SignupController;

import io.javalin.Javalin;

public class Rotas {

    private CarpinteiroDashboardController carpinteiroDashboardController;
    private LoginController loginController;
    private SignupController signupController;
    private ClienteDashboardController clienteController;

    public Rotas() {
        this.carpinteiroDashboardController = new CarpinteiroDashboardController();
        this.loginController = new LoginController();
        this.signupController = new SignupController();
        this.clienteController = new ClienteDashboardController();
    }

    public void registraRotas(Javalin app) {

        app.get("/carpinteiro_Dashboard", carpinteiroDashboardController.get);
        app.get("/carpinteiro_Dashboard/atualizar", carpinteiroDashboardController.atualizar);

        app.get("/", loginController.get);
        app.post("/", loginController.post);
        app.get("/signup", signupController.get);
        app.post("/signup", signupController.post);

        app.get("/cliente_Dashboard", clienteController.get);
        app.get("/cliente_Dashboard/fazerPedido", clienteController.exibirFazerPedido); // Exibe página
        app.post("/cliente_Dashboard/fazerPedido", clienteController.fazerPedido);      // Envia formulário
        app.get("/cliente_Dashboard/cancelarPedido", clienteController.cancelarPedido);
    }
}

package com.miguel.vannucci;

import com.miguel.vannucci.config.AppConfig;
import com.miguel.vannucci.routes.Rotas;



public class App {

    public static void main(String[] args) {

        Rotas rotas = new Rotas();
        AppConfig appConfig = new AppConfig();

        rotas.registraRotas(appConfig.iniciaApp());

    }
}

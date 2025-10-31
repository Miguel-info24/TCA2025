package com.miguel.vannucci.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class FabricaConexoes {

    public static final Dotenv dotenv = Dotenv.load();
    private static volatile FabricaConexoes instance;
    // carregar dados de conexão do .env
    private final String nameDB = dotenv.get("DB_NAME");
    private final String user = dotenv.get("DB_USER");
    private final String password = dotenv.get("DB_PASSWORD");
    private final String host = dotenv.get("DB_HOST");
    private final String port = dotenv.get("DB_PORT");

    private FabricaConexoes() {}

    public static FabricaConexoes getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new FabricaConexoes();
        return instance;
    }

    public Connection getConnection() {

        try {
            String url = "jdbc:mysql:" + host + ":" + port + "/" + nameDB + "?user=" + user + "&password=" + password;
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException("erro ao conectar ao banco de dados: ", e);
        }
    }
}

//jdbc:mysql://wagnerweinert.com.br:3306/info24_MIGUEL?user=info24_MIGUEL&password=info24_MIGUEL
//jdbc:mysql://wagnerweinert.com.br:3306/info24_MIGUEL?user=info24_MIGUEL&password=info24_MIGUEL
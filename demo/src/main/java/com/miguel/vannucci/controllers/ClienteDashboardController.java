package com.miguel.vannucci.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.miguel.vannucci.DAOs.DAOsPedidoImpl;
import com.miguel.vannucci.models.Pedido;
import com.miguel.vannucci.models.User;

import io.javalin.http.Handler;

public class ClienteDashboardController {

    private final DAOsPedidoImpl pedidoDAO = new DAOsPedidoImpl();

    // Painel principal
    public Handler get = ctx -> {
        User currentUser = ctx.sessionAttribute("currentUser");
        if (currentUser == null) {
            ctx.redirect("/");
            return;
        }

        Map<String, Object> model = new HashMap<>();
        model.put("name", currentUser.getName());
        model.put("email", currentUser.getEmail());

        // 🔹 Buscar pedidos do usuário logado
        List<Pedido> pedidos = pedidoDAO.getPedidosByUserId(currentUser.getId());
        model.put("pedidos", pedidos);

        ctx.render("cliente_Dashboard.ftl", model);
    };

    // Exibe o formulário de fazer pedido
    public Handler exibirFazerPedido = ctx -> {
        User currentUser = ctx.sessionAttribute("currentUser");
        if (currentUser == null) {
            ctx.redirect("/");
            return;
        }

        Map<String, Object> model = new HashMap<>();
        model.put("name", currentUser.getName());
        model.put("email", currentUser.getEmail());

        String success = ctx.queryParam("success");
        String error = ctx.queryParam("error");
        String tipo = ctx.queryParam("tipo");

        if (success != null) model.put("success", true);
        if (error != null) model.put("error", true);
        model.put("tipo", tipo != null ? tipo : "");

        ctx.render("cliente_fazerPedido.ftl", model);
    };

    // Faz o pedido
    public Handler fazerPedido = ctx -> {
        try {
            User currentUser = ctx.sessionAttribute("currentUser");
            if (currentUser == null) {
                ctx.redirect("/");
                return;
            }

            String descricao = ctx.formParam("descricao_pedido");
            double preco = Double.parseDouble(ctx.formParam("preco"));
            String dataFimStr = ctx.formParam("data_fim");
            String tipo = ctx.formParam("tipo");
            int idBarco = Integer.parseInt(ctx.formParam("id_Barco"));

            java.time.LocalDate dataInicio = java.time.LocalDate.now();
            java.time.LocalDate dataFim = java.time.LocalDate.parse(dataFimStr);

            pedidoDAO.addPedido(
                currentUser.getId(),
                descricao,
                preco,
                "Pendente",
                dataInicio,
                dataFim,
                idBarco
            );

            ctx.redirect("/cliente_Dashboard/fazerPedido?success=true&tipo=" + tipo);

        } catch (Exception e) {
            e.printStackTrace();
            ctx.redirect("/cliente_Dashboard/fazerPedido?error=true");
        }
    };

    public Handler cancelarPedido = ctx -> {
        ctx.render("cliente_cancelarPedido.ftl");
    };
}

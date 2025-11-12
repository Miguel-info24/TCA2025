package com.miguel.vannucci.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.miguel.vannucci.DAOs.DAOsBarcoImpl;
import com.miguel.vannucci.DAOs.DAOsPedidoImpl;
import com.miguel.vannucci.models.Barco;
import com.miguel.vannucci.models.Pedido;
import com.miguel.vannucci.models.User;
import com.miguel.vannucci.models.interfaces.barcoDAO;

import io.javalin.http.Handler;

public class ClienteDashboardController {

    private final DAOsPedidoImpl pedidoDAO = new DAOsPedidoImpl();
    private final barcoDAO barcoDAO = new DAOsBarcoImpl();

    public Handler get = ctx -> {
        User currentUser = ctx.sessionAttribute("currentUser");
        if (currentUser == null) {
            ctx.redirect("/");
            return;
        }

        Map<String, Object> model = new HashMap<>();
        model.put("name", currentUser.getName());
        model.put("email", currentUser.getEmail());

        List<Pedido> pedidos = pedidoDAO.getPedidosByUserId(currentUser.getId());

        for (Pedido pedido : pedidos) {
            String barcoEscolhido;

            if (pedido.getBarcoPersonalizado() != null && !pedido.getBarcoPersonalizado().isEmpty()) {
                barcoEscolhido = pedido.getBarcoPersonalizado();
            } else {
                Barco molde = barcoDAO.getBarcosById(pedido.getIdBarcoMolde()).stream().findFirst().orElse(null);
                barcoEscolhido = molde != null
                        ? molde.getNomeBarco() + " - " + molde.getTipoBarco()
                        : "—";
            }

            pedido.setBarcoEscolhido(barcoEscolhido);
        }

        model.put("pedidos", pedidos);

        ctx.render("cliente_Dashboard.ftl", model);
    };

    public Handler exibirFazerPedido = ctx -> {
        DAOsBarcoImpl barcoDAO = new DAOsBarcoImpl();
        List<Barco> barcos = barcoDAO.getBarcos();
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

        if (success != null) {
            model.put("success", true);
        }
        if (error != null) {
            model.put("error", true);
        }
        model.put("tipo", tipo != null ? tipo : "");

        model.put("barcos", barcos);

        ctx.render("cliente_fazerPedido.ftl", model);
    };

    public Handler fazerPedido = ctx -> {
        try {
            User currentUser = ctx.sessionAttribute("currentUser");
            if (currentUser == null) {
                ctx.redirect("/");
                return;
            }

            String descricao = ctx.formParam("descricao_pedido");
            String tamanhoPedido = ctx.formParam("tamanho_pedido");
            String corPedido = ctx.formParam("cor_pedido");
            String barcoPersonalizado = ctx.formParam("barco_personalizado"); // pode ser vazio
            String dataFimStr = ctx.formParam("data_fim");
            String tipo = ctx.formParam("tipo");

            String idBarcoStr = ctx.formParam("id_Barco");
            Integer idBarco = (idBarcoStr == null || idBarcoStr.isEmpty()) ? null : Integer.parseInt(idBarcoStr);

            java.time.LocalDate dataInicio = java.time.LocalDate.now();
            java.time.LocalDate dataFim = java.time.LocalDate.parse(dataFimStr);
            double precoInicial = 0.0;

            pedidoDAO.addPedido(
                    currentUser.getId(),
                    descricao,
                    precoInicial,
                    "Pendente",
                    dataInicio,
                    dataFim,
                    idBarco,
                    tamanhoPedido,
                    corPedido,
                    barcoPersonalizado
            );

            ctx.redirect("/cliente_Dashboard/fazerPedido?success=true");

        } catch (Exception e) {
            e.printStackTrace();
            ctx.redirect("/cliente_Dashboard/fazerPedido?error=true");
        }
    };

    public Handler cancelarPedido = ctx -> {
        ctx.render("cliente_cancelarPedido.ftl");
    };

    public Handler cancelarPedidoPost = ctx -> {
        try {
            int idPedido = Integer.parseInt(ctx.formParam("id_pedido"));
            boolean sucesso = pedidoDAO.cancelarPedido(idPedido);

            if (sucesso) {
                ctx.redirect("/cliente_Dashboard/cancelarPedido?success=true");
            } else {
                ctx.redirect("/cliente_Dashboard/cancelarPedido?error=true");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ctx.redirect("/cliente_Dashboard/cancelarPedido?error=true");
        }
    };

}

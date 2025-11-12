<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="name" content="Miguel Vannucci">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/cliente_cancelarPedido.css">
    <title>Cancelar - pedido Cliente</title>
</head>

<body>
    <header>
        <div class="logo-area">
            <img src="/img/logo.png" alt="Logo">
            <h1 class="texto-principal">Os Barqueiros</h1>
        </div>
    </header>
    <div class="container">
        <div class="menu">
            <nav class="menu-topo">
                <ul>
                    <li><a href="/cliente_Dashboard">Voltar</a></li>
                </ul>
            </nav>
        </div>

        <div class="content">
            <h2>Cancelar Pedido</h2>
            <form class="cancelar-form" id="cancelarForm" method="post" action="/cliente_Dashboard/cancelarPedido">
                <label for="pedidoId">ID do Pedido</label>
                <input type="text" id="pedidoId" name="id_pedido" placeholder="Ex: 12345" required>

                <button type="submit">Cancelar Pedido</button>
            </form>

            <#if success??>
                <div style="color: #0da8e9; margin-top: 15px; font-weight: bold;">
                    Pedido cancelado com sucesso!
                </div>
            </#if>
            <#if error??>
                <div style="color: red; margin-top: 15px; font-weight: bold;">
                    Erro ao cancelar o pedido.
                </div>
            </#if>
        </div>
</body>

</html>
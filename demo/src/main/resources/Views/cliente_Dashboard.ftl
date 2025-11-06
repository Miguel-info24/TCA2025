<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="name" content="Miguel Vannucci">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/cliente_dashBoard.css">
    <title>Cliente Dashboard</title>
</head>

<body>
    <header>
        <div class="logo-area">
            <img src="img/logo.png" alt="Logo">
            <h1 class="texto-principal">Os Barqueiros</h1>
        </div>
    </header>

    <section class="container">
        <div class="menu">
            <nav class="menu-topo">
                <ul>
                    <li><a href="/cliente_Dashboard/fazerPedido">Fazer Pedido</a></li>
                    <li><a href="/cliente_Dashboard/cancelarPedido">Cancelar Pedido</a></li>
                    <li><a href="/" id="logout">Logout</a></li>

                </ul>
            </nav>
        </div>

        <div class="content">
            <h2>Olá, ${name}</h2>
            <h2 class="pedidos">Atualizações do seu pedido</h2>
            <div class="pedidos-container" id="pedidos-container">
                <#if pedidos?? && (pedidos?size > 0)>
                    <#list pedidos as p>
                        <div class="pedido-card">
                            <h3>Pedido #${p.id}</h3>
                            <p><strong>Descrição:</strong> ${p.descricao}</p>
                            <p><strong>Preço:</strong> R$ ${p.preco}</p>
                            <p><strong>Status:</strong> ${p.status}</p>
                            <p><strong>Início:</strong> ${p.dataInicio}</p>
                            <p><strong>Entrega:</strong> ${p.dataFim}</p>
                        </div>
                    </#list>
                    <#else>
                        <p>Você ainda não fez nenhum pedido.</p>
                </#if>
            </div>

        </div>
    </section>

</body>

</html>
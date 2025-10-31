<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="name" content="Miguel Vannucci">
    <title>Cliente - Fazer Pedido</title>
    <link rel="stylesheet" href="/css/style.css"> 
    <link rel="stylesheet" href="/css/cliente_fazerPedido.css"> 
</head>

<body>
    <header>
        <div class="logo-area">
            <img src="/img/logo.png" alt="Logo">
            <h1 class="texto-principal">Os Barqueiros</h1>
        </div>
    </header>

    <div class="container">
        <!-- Menu lateral -->
        <div class="menu">
            <nav class="menu-topo">
                <ul>
                    <li><a href="/cliente_Dashboard">Voltar</a></li>
                </ul>
            </nav>
        </div>

        <!-- Conteúdo -->
        <div class="content">
            <h2>Fazer um novo pedido</h2>
            <form class="pedido-form" id="pedidoForm">
                <label for="descricao">Descrição do serviço</label>
                <textarea id="descricao" placeholder="Ex: Pintura do casco"></textarea>

                <label for="tipo">Tipo de serviço</label>
                <select id="tipo">
                    <option>Selecione...</option>
                    <option>Conserto</option>
                    <option>Pintura</option>
                    <option>Manutenção</option>
                </select>

                <label for="barco">Barco</label>
                <input type="text" id="barco" placeholder="Ex: Barco Azul">

                <button type="submit">Enviar Pedido</button>
            </form>

            <div id="mensagemSucesso" style="display:none; color: #0da8e9; margin-top: 15px; font-weight: bold;"></div>

        </div>
    </div>
    <script src="/js/cliente_fazerPedido.js"></script>


</body>

</html>
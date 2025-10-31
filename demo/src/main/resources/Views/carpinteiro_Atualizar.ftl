<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="name" content="Miguel Vannucci">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/carpinteiro_Atualizar.css">

    <title>Carpinteiro Atualizar</title>
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
                    <li><a href="/carpinteiro_Dashboard">Voltar</a></li>
                </ul>
            </nav>
        </div>
        <!-- Conteúdo -->
        <div class="content">
            <h2>Atualizar</h2>
            <form class="pedido-form" id="pedidoForm">
                <label for="descricao">Descrição do serviço</label>
                <textarea id="descricao" placeholder="Ex: Pintura do casco"></textarea>

                <label for="tipo">Tipo de serviço</label>
                <select id="tipo">
                    <option>Selecione...</option>
                    <option>Conserto</option>
                    <option>Pintura</option>
                </select>

                <label for="status">Status do serviço</label>
                <select id="status">
                    <option>Selecione...</option>
                    <option>Em andamento</option>
                    <option>Concluido</option>
                </select>
                <input type="text" id="barco" placeholder="Descrição de andamento">

                <button type="submit">Atualizar</button>
    </div>
</body>

</html>
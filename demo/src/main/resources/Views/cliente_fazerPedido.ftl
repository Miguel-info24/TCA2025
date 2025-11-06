<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <title>Fazer Pedido</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/popup.css">
    <link rel="stylesheet" href="/css/cliente_fazerPedido.css">

</head>

<body>

    <header>
        <div class="logo-area">
            <img src="/img/logo.png" alt="Logo">
            <h1 class="texto-principal">Os Barqueiros</h1>
        </div>
    </header>
    <div class="pedido-container">
        <h2>Fazer Pedido</h2>

        <form method="post" action="/cliente_Dashboard/fazerPedido">
            <label for="descricao">Descrição</label>
            <textarea id="descricao" name="descricao_pedido" required></textarea>

            <label for="preco">Preço</label>
            <input type="number" id="preco" name="preco" required>

            <label for="data_fim">Data de entrega</label>
            <input type="date" id="data_fim" name="data_fim" required>

            <label for="id_Barco">Selecione o barco:</label>
            <select name="id_Barco" id="id_Barco" required>
                <#list barcos as barco>
                    <option value="${barco.idBarco}">
                        ${barco.tipo_barco} - ${barco.tamanho_barco} (${barco.material_barco})
                    </option>
                </#list>
            </select>


            <label for="tipo">Tipo do pedido</label>
            <select id="tipo" name="tipo">
                <option value="barco existente">Barco existente</option>
                <option value="barco novo">Barco novo</option>
            </select>

            <div class="barco-novo-form" style="display: none;">
                <h3>Informações do novo barco</h3>
                <input type="text" name="nomeBarco" placeholder="Nome do barco">
                <input type="text" name="cor" placeholder="Cor">
                <input type="number" name="tamanho" placeholder="Tamanho (m)">
                <input type="text" name="material" placeholder="Material">
            </div>



            <button type="submit">Enviar Pedido</button>
        </form>
    </div>

    <!-- POP-UP -->
    <#if success??>
        <div class="popup show">
            <div class="popup-content">
                <p> Pedido criado com sucesso!</p>
                <a href="/cliente_Dashboard" class="popup-btn">Fechar</a>
            </div>
        </div>
        <#elseif error??>
            <div class="popup show">
                <div class="popup-content error">
                    <p> Erro ao criar pedido. Tente novamente.</p>
                    <a href="/cliente_Dashboard" class="popup-btn">Fechar</a>
                </div>
            </div>
    </#if>
    <script src="/js/cliente_fazerPedido.js"></script>
</body>

</html>
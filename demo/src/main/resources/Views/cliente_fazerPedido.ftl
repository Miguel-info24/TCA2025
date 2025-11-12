<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <title>Fazer Pedido</title>
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="/css/cliente_fazerPedido.css">
  <link rel="stylesheet" href="/css/popup.css">
</head>

<body>
  <header>
    <div class="logo-area">
      <img src="img/logo.png" alt="Logo">
      <h1 class="texto-principal">Os Barqueiros</h1>
    </div>
  </header>

  <div class="pedido-container">
    <h2>Fazer Pedido</h2>

    <#if success??>
      <div class="popup show">
        <div class="popup-content">
          <p>Pedido criado com sucesso!</p><a href="/cliente_Dashboard" class="popup-btn">Fechar</a>
        </div>
      </div>
      <#elseif error??>
        <div class="popup show">
          <div class="popup-content error">
            <p>Erro ao criar pedido. Tente novamente.</p><a href="/cliente_Dashboard" class="popup-btn">Fechar</a>
          </div>
        </div>
    </#if>

    <form method="post" action="/cliente_Dashboard/fazerPedido">
      <label for="descricao">Descrição do pedido</label>
      <textarea id="descricao" name="descricao_pedido" required></textarea>

      <label for="id_Barco">Selecione o molde de barco</label>
      <select name="id_Barco" id="id_Barco">
        <#if barcos?? && (barcos?size> 0)>
          <#list barcos as barco>
            <option value="${barco.idBarco}">${barco.nomeBarco} — ${barco.tipoBarco}</option>
          </#list>
          <#else>
            <option value="">Nenhum molde disponível</option>
        </#if>
      </select>

      <label for="barco_personalizado">Outro barco (especifique se não encontrou na lista)</label>
      <input type="text" id="barco_personalizado" name="barco_personalizado"
        placeholder="Descreva o barco desejado (ex.: 'Lancha com proa alta, 6m')">

      <label for="tamanho_pedido">Tamanho desejado</label>
      <input type="text" id="tamanho_pedido" name="tamanho_pedido" placeholder="Ex.: 6m, 5.5m, Médio" required>

      <label for="cor_pedido">Cor desejada</label>
      <input type="text" id="cor_pedido" name="cor_pedido" placeholder="Ex.: Branco, Azul" required>

      <label for="data_fim">Data de entrega</label>
      <input type="date" id="data_fim" name="data_fim" required>

      <label for="tipo">Tipo do pedido</label>
      <select id="tipo" name="tipo">
        <option value="barco existente">Barco existente</option>
        <option value="barco novo">Barco novo</option>
      </select>

      <button type="submit">Enviar Pedido</button>
    </form>
  </div>

  <script src="js/cliente_fazerPedido.js"></script>
</body>

</html>
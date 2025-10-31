<!DOCTYPE html>
<html lang="pt-BR">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="name" content="Miguel Vannucci">
  <title>Cadastro - Os Barqueiros</title>
  <link rel="stylesheet" href="/css/signup.css">
  <link rel="stylesheet" href="/css/style.css">

</head>

<body>
  <header>
    <div class="logo-area">
      <img src="img/logo.png" alt="Logo">
      <h1>Os Barqueiros</h1>
    </div>
  </header>

  <div class="container">
    <div class="left">
      <h2 class="texto">Cadastre-se e</h2>
      <img src="img/barco.png" alt="Imagem de barco" class="barco">
      <h2 class="texto">Entre para o nosso time<br>e faça parte da jornada!</h2>
    </div>

    <div class="right">
      <div class="signup-box">
        <h2>Crie sua Conta</h2>
        <form id="signupForm" action="/signup" method="post">
          <label for="nome">Nome</label>
          <input type="text" id="name" name="name" placeholder="Digite seu nome" required>

          <label for="email">Email</label>
          <input type="email" id="email" name="email" placeholder="Digite seu email" required>

          <label for="senha">Senha</label>
          <input type="password" id="senha" name="password" placeholder="Digite sua senha" required>

          <label for="confirmar">Confirmar Senha</label>
          <input type="password" id="confirmar" name="confirmar" placeholder="Confirme sua senha" required>

          <label for="telefone">Telefone</label>
          <input type="tel" id="telefone" name="phone" placeholder="Digite seu telefone" required>

          <label for="cpf">CPF</label>
          <input type="text" id="cpf" name="cpf" placeholder="Digite seu CPF" required>

          <label for="tipo">Escolha o seu Cadastro:</label>
          <select id="tipo" name="tipo">
            <option value="carpinteiro">Carpinteiro</option>
            <option value="cliente">Cliente</option>
          </select>

          <button type="submit">Cadastrar</button>
        </form>


        <div class="redirect">
          <p>Já tem conta? <a href="/">Fazer login</a></p>
        </div>
      </div>
    </div>
  </div>
</body>

</html>
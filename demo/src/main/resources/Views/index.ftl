<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="name" content="Miguel Vannucci">
  <title>Login - Os Barqueiros</title>
  <link rel="stylesheet" href="/css/login.css">
  <link rel="stylesheet" href="/css/style.css">
</head>
<body>
  <header>
    <div class="logo-area">
      <img src="/img/logo.png" alt="Logo">
      <h1 class="texto-principal">Os Barqueiros</h1>
    </div>
  </header>

  <section class="container">
    <div class="left">
      <img src="/img/barco.png" alt="Imagem de barco" class="barco">
      <h2 class="texto">Bem-vindo de volta!<br>Logue e continue sua jornada com a gente</h2>
    </div>

    <div class="right">
      <div class="login-box">
        <h2>Login - <#if userType??>${userType?cap_first}</#if></h2>

        <form action="/" method="post">

          <label for="email">E-mail</label>
          <input type="email" id="email" name="email" placeholder="Digite seu e-mail" required>

          <label for="senha">Senha</label>
          <input type="password" id="senha" name="senha" placeholder="Digite sua senha" required>

          <button type="submit">Entrar</button>
        </form>

        <p class="redirect">Não tem conta? <a href="/signup">Cadastre-se</a></p>
      </div>
    </div>
  </section>
</body>
</html>

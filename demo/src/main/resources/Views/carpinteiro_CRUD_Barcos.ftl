<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="name" content="Miguel Vannucci">
    <link rel="stylesheet" href="/css/style.css">
    <title>carpinteiro_CRUD_Barcos</title>
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
                    <li><a href="/carpinteiro_Dashboard">Voltar</a></li>
                </ul>
            </nav>
        </div>
    </div>
    <div class="content">
        <h2>Criação de Barcos</h2>
        <form class="barco-form" id="barcoForm">

            <label for="tipoBarco">Tipo de Barco</label>
            <input type="text" id="tipoBarco" placeholder="Ex: Veleiro">

            <button type="submit">Adicionar Barco</button>
        </form>
        
    </div>

</body>
</html>
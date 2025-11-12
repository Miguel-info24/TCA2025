
DROP TABLE IF EXISTS TCA_Barcos_User;
CREATE TABLE TCA_Barcos_User(
    idUser INT AUTO_INCREMENT PRIMARY KEY,
    cpf VARCHAR(15) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL 
    tipo VARCHAR(11) NOT NULL
);

DROP TABLE IF EXISTS TCA_Barcos_Carpinteiro;
CREATE TABLE TCA_Barcos_Carpinteiro(
    idCarpinteiro INT AUTO_INCREMENT PRIMARY KEY,
    FOREIGN KEY(idCarpinteiro) REFERENCES TCA_Barcos_User(idUser)
);
DROP TABLE IF EXISTS TCA_Barcos_Client;
CREATE TABLE TCA_Barcos_Client (
    idCliente INT AUTO_INCREMENT PRIMARY KEY,
    FOREIGN KEY (idCliente) REFERENCES TCA_Barcos_User(idUser)
);
DROP TABLE IF EXISTS TCA_Barcos_pedido;
CREATE TABLE TCA_Barcos_pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    nome_pedido VARCHAR(100) NOT NULL,
    descricao_pedido VARCHAR(255) NOT NULL, j
    preco DECIMAL(10,2) NOT NULL,
    status_pedido VARCHAR(50) NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    id_Barco INT NOT NULL,
    FOREIGN KEY (id_Barco) REFERENCES TCA_Barcos_barco(idBarco)
);
DROP TABLE IF EXISTS TCA_Barcos_barco;
CREATE TABLE TCA_Barcos_barco (
    idBarco INT AUTO_INCREMENT PRIMARY KEY,
    tipo_barco VARCHAR(50) NOT NULL,
    tamanho_barco VARCHAR(50) NOT NULL,
    material_barco VARCHAR(50) NOT NULL,
);

ALTER TABLE TCA_Barcos_barco
ADD COLUMN idUser INT,
ADD FOREIGN KEY (idUser) REFERENCES TCA_Barcos_User(idUser);

INSERT INTO TCA_Barcos_barco (idBarco, nome_barco, tipo_barco. cor_barco, tamanho_barco, material_barco, idUser) VALUES
(1, 'marujo feliz', 'Veleiro', 'azul', '30', 'Fibra de vidro', 1),
(2, 'fura-olho', 'Iate', 'verde', '50', 'Aço', 1),
(3, 'lua-cheia', 'Canoa', 'vermelho', '15', 'Madeira', 2);
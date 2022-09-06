CREATE TABLE Permissoes (
id_permissao INTEGER AUTO_INCREMENT PRIMARY KEY,
tipo_permissao VARCHAR(20)
);

CREATE TABLE Reserva (
id_reserva INTEGER AUTO_INCREMENT PRIMARY KEY,
origem_reserva VARCHAR(50),
destino_reserva VARCHAR(50),
ida_reserva DATETIME,
volta_reserva DATETIME,
acompanhantes_reserva INTEGER,
valor_reserva DECIMAL(5,2),
id_cliente VARCHAR(10)
);

CREATE TABLE Hospedagem (
id_hospedagem INTEGER AUTO_INCREMENT PRIMARY KEY,
nome_hospedagem VARCHAR(80),
valor_hospedagem DECIMAL(5,2),
qtddias_hospedagem INTEGER,
id_reserva INTEGER,
FOREIGN KEY(id_reserva) REFERENCES Reserva (id_reserva)
);

CREATE TABLE Transporte (
id_cia_transporte INTEGER AUTO_INCREMENT PRIMARY KEY,
nome_transporte VARCHAR(50),
valor_transporte DECIMAL(5,2),
id_reserva INTEGER,
FOREIGN KEY(id_reserva) REFERENCES Reserva (id_reserva)
);

CREATE TABLE Usuario (
login_usuario VARCHAR(80),
senha_usuario VARCHAR(10),
fone_usuario VARCHAR(20),
nome_usuario VARCHAR(80),
id_usuario INTEGER AUTO_INCREMENT PRIMARY KEY,
id_permissao INTEGER,
FOREIGN KEY(id_permissao) REFERENCES Permissoes (id_permissao)
);

CREATE TABLE Cliente (
id_cliente INTEGER AUTO_INCREMENT PRIMARY KEY,
cpf_cliente VARCHAR(20),
email_cliente VARCHAR(80),
nome_cliente VARCHAR(80),
rg_cliente VARCHAR(10),
estado VARCHAR(50),
rua VARCHAR(50),
cidade VARCHAR(50),
complemento VARCHAR(50),
id_usuario VARCHAR(10),
FOREIGN KEY(id_usuario) REFERENCES Usuario (id_usuario)
);

ALTER TABLE Reserva ADD FOREIGN KEY(id_cliente) REFERENCES Cliente (id_cliente);

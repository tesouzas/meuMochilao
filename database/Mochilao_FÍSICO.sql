CREATE DATABASE Mochilao;

USE Mochilao;

CREATE TABLE cliente (
id_cliente INTEGER PRIMARY KEY auto_increment,
nome_cliente VARCHAR(80),
cpf_cliente VARCHAR(11),
cidade_cliente VARCHAR(80)
);

CREATE TABLE viagem (
id_viagem INTEGER PRIMARY KEY auto_increment,
destino_viagem VARCHAR(10),
pacote_viagem VARCHAR(10),
valor_pacote_viagem DECIMAL(10)
);

CREATE TABLE reserva (
id_reserva INTEGER PRIMARY KEY auto_increment,
data_ida DATE,
data_volta DATE,
valor_reserva DECIMAL(5.2),
dias_reserva integer,
id_viagem INTEGER,
id_cliente INTEGER,
FOREIGN KEY(id_cliente) REFERENCES cliente (id_cliente),
FOREIGN KEY(id_viagem) REFERENCES viagem (id_viagem)
);

insert into cliente (nome_cliente, cpf_cliente, cidade_cliente) values 
('Marcos Silva', '12345678910', 'Recife'),
('Maria Viana', '98765432110', 'Jaboatão');

insert into viagem (destino_viagem, pacote_viagem, valor_pacote_viagem) values 
('Catalunha', 'Catalunha', 9.876),
('Eua', 'Eua', 2.799);

insert into reserva (data_ida, data_volta, valor_reserva, dias_reserva, id_cliente, id_viagem) values 
('2022-09-10','2022-09-15', 500, 5, 1, 2),
('2022-09-14','2022-09-24', 1000, 10, 2, 1);



select * from cliente;
select * from viagem;
select * from reserva;

select * from cliente where cidade_cliente = 'Recife';

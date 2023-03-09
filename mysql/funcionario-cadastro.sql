create database dbcadastros;
show databases;
use dbcadastros; 

create table funcionarios(
id int primary key auto_increment,
nome varchar (50) not null,
salario double not null default '0'
);

create table cadastro(
	idcad int primary key auto_increment, 
    nome varchar (50) not null,
	Nascimento varchar (50),
    endereço varchar (100),
    CPF int (11) not null,
	email varchar (50),
	tel int (9),
    cargo varchar (30) not null
);
show tables;
describe cadastro;

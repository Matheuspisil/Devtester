
use dbcadastro;

create table cadastro(
idcad int primary key auto_increment,

		nome varchar(50) not null,
		cpf varchar(50) not null,
		cargo varchar(50) not null,
		nascimento varchar(50),
		endereco varchar (50),
		email varchar (50),
		tel varchar(50)

);


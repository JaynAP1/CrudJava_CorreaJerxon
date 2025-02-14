drop database if exists notasVibrantes;
create database notasVibrantes;

SET SQL_SAFE_UPDATES = 0;

use notasVibrantes;

create table Cliente(
	id int not null primary key,
	nombre varchar(50) not null,
    apellido varchar(50) not null,
    correo varchar(50) not null,
    telefono varchar(12)
);

create table Concierto(
	id int not null primary key,
    nombre varchar(50) not null,
    artista varchar(50) not null,
    fecha date not null,
    lugar varchar(50) not null,
    precioBase decimal(10,2)
);

create table Ticket(
	id int not null primary key auto_increment,
    id_cliente int,
    id_concierto int,
    zona varchar(50) not null,
    precioFinal decimal(10,2),
    fechaCompra date,
    cantidad int not null,
    foreign key (id_cliente) references Cliente(id),
    foreign key (id_concierto) references Concierto(id)
);

create table Zona(
	id int not null primary key,
    id_seleccion int not null,
    id_concierto int not null,
    nombreZona varchar(50) not null,
    capacidad int not null,
    precioAdicional decimal(10,2),
    foreign key (id_concierto) references concierto(id)
);

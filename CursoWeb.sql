CREATE DATABASE CursoWeb;

USE CursoWeb;

CREATE TABLE Producto(
	idProducto int primary key auto_increment,
    nombre varchar(25),
    descripcion varchar(50),
    precio float,
    estado varchar(20)
);
	
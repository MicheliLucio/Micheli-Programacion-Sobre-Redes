DROP DATABASE IF EXISTS TiendaBDDTP3;
CREATE DATABASE TiendaBDDTP3;
USE TiendaBDDTP3;

DROP TABLE IF EXISTS stock;
CREATE TABLE stock(
	id int primary KEY auto_increment,
	nombre varchar(100),
	descripcion varchar(255),
	precio_compra float,
	precio_venta float,
	cant int,
	discontinuado boolean
);

INSERT INTO stock(nombre, descripcion, precio_compra, precio_venta, cant, discontinuado) VALUES('PC', 'GAMER', 50000.00, 80000.00, 10, false);
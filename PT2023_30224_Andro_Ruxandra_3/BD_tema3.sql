drop database if exists tp_proiect3;
create database tp_proiect3;

use tp_proiect3;

CREATE TABLE `tp_proiect3`.`Client` (
	id INT NOT NULL AUTO_INCREMENT,
    nume VARCHAR(45) ,
    email VARCHAR(45),
    PRIMARY KEY (id)
 );
 
 CREATE TABLE `tp_proiect3`.`Product` (
	id INT NOT NULL AUTO_INCREMENT,
    price int,
    nume VARCHAR(45) ,
    prodInStock int,
    PRIMARY KEY (id)
 );
 
 CREATE TABLE `tp_proiect3`.`Order` (
	id INT NOT NULL AUTO_INCREMENT,
    idClient int,
    idProdus int,
   cantitate int,
    PRIMARY KEY (id)
 );
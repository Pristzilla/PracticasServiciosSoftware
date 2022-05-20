/*
-- Query: SELECT * FROM agenciaseguros.cliente
LIMIT 0, 1000

-- Date: 2022-05-20 18:18
*/
use agenciaseguros;
INSERT INTO `cliente` (`dni`,`email`,`nombre`) VALUES ('12345678A','ana@gmail.es','Ana');
INSERT INTO `cliente` (`dni`,`email`,`nombre`) VALUES ('12345678B','pepe@gmai.com','Pepe');
INSERT INTO `cliente` (`dni`,`email`,`nombre`) VALUES ('12345678C','susana@gmail.com','Susana');
INSERT INTO `agenciaseguros`.`seguro` (`dtype`, `id`, `vehiculo_fk`) VALUES ('TERCEROS', 'XXX-123456', 'CHE1234');

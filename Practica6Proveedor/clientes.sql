/*
-- Query: SELECT * FROM agenciaseguros.cliente
LIMIT 0, 1000

-- Date: 2022-05-20 18:18
*/
use agenciaseguros;
INSERT INTO `cliente` (`dni`,`email`,`nombre`) VALUES ('12345678A','ana@gmail.es','Ana');
INSERT INTO `cliente` (`dni`,`email`,`nombre`) VALUES ('12345678B','pepe@gmai.com','Pepe');
INSERT INTO `cliente` (`dni`,`email`,`nombre`) VALUES ('12345678C','susana@gmail.com','Susana');
INSERT INTO `vehiculo` (`matricula`,`potencia`,`uso_profesional`) VALUES ('CHE1234',80,0);
INSERT INTO `vehiculo` (`matricula`,`potencia`,`uso_profesional`) VALUES ('FUR1234',120,1);
INSERT INTO `vehiculo` (`matricula`,`potencia`,`uso_profesional`) VALUES ('MOT1234',90,0);
INSERT INTO `agenciaseguros`.`terceros` (`id`, `vehiculo_fk`, `cliente_fk`) VALUES ('XXX-123456', 'CHE1234', '12345678A');
INSERT INTO `agenciaseguros`.`seguro` (`tipo_seguro`, `id`, `vehiculo_fk`, `cliente_fk`) VALUES ('TERCEROS','XXX-123456', 'CHE1234', '12345678A');


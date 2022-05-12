package es.unican.ss.Practica6Proveedor.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import es.unican.ss.Practica6Proveedor.entidades.Vehiculo;

public interface VehiculosRepository extends JpaRepository<Vehiculo, String> {

}

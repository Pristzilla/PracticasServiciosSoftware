package es.unican.ss.Practica6Proveedor.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.unican.ss.Practica6Proveedor.entidades.Seguro;

public interface SegurosRepository extends JpaRepository<Seguro, Integer> {

	@Query(value = "SELECT * FROM SEGURO WHERE vehiculo_fk = ?1", nativeQuery = true)
	public Seguro findByVehiculo_fk(String vehicuklo_fk);

}

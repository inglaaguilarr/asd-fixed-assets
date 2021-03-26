package co.com.laaguilar.controllers.repositories;

import co.com.laaguilar.entities.Area;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que permite extender las operaciones de consulta CRUD
 * proporcionadas por JpaRepository para la clase Area
 *
 * @author laaguilar
 */
public interface IAreaRepository extends JpaRepository<Area, Long> {

}

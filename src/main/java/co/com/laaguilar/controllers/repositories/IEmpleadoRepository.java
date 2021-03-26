package co.com.laaguilar.controllers.repositories;

import co.com.laaguilar.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que permite extender las operaciones de consulta CRUD
 * proporcionadas por JpaRepository para la clase Empleado
 *
 * @author laaguilar
 */
public interface IEmpleadoRepository extends JpaRepository<Empleado, Long> {

}

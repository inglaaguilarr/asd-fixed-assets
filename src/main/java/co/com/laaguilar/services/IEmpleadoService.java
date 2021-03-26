package co.com.laaguilar.services;

import co.com.laaguilar.entities.Empleado;
import java.util.List;

/**
 * Interface con las firmas de los metodos para gestionar las consultas de
 * Empleado
 *
 * @author laaguilar
 */
public interface IEmpleadoService {

    List<Empleado> findAll();
}

package co.com.laaguilar.services;

import co.com.laaguilar.controllers.repositories.IEmpleadoRepository;
import co.com.laaguilar.entities.Empleado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para gestionar las consultas de Empleado
 *
 * @author laaguilar
 */
@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private IEmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

}

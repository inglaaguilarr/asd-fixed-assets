package co.com.laaguilar.services;

import co.com.laaguilar.controllers.repositories.IActivoFijoRepository;
import co.com.laaguilar.entities.ActivoFijo;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para gestionar las consultas de Activo Fijo
 *
 * @author laaguilar
 */
@Service
public class ActivoFijoService implements IActivoFijoService {

    @Autowired
    private IActivoFijoRepository activoFijoRepository;

    @Override
    public List<ActivoFijo> findAll() {
        List<ActivoFijo> activos = (List<ActivoFijo>) activoFijoRepository.findAll();
        return activos;
    }

    @Override
    public ActivoFijo findById(Long id) {
        ActivoFijo activo = activoFijoRepository.findActById(id);
        return activo;
    }

    @Override
    public ActivoFijo findByParameters(Long id, Date fechaCompra, String serial) {
        ActivoFijo activo = activoFijoRepository.findByParameters(id, fechaCompra, serial);
        return activo;
    }

    @Override
    public List<ActivoFijo> findByDate(Date fechaCompra) {
        List<ActivoFijo> activos = activoFijoRepository.findByDate(fechaCompra);
        return activos;
    }

    @Override
    public ActivoFijo findBySerial(String serial) {
        ActivoFijo activo = activoFijoRepository.findBySerial(serial);
        return activo;
    }

    @Override
    public ActivoFijo saveActivo(ActivoFijo activoFijo) {
        return activoFijoRepository.saveAndFlush(activoFijo);
    }

    /**
     *
     * @param id
     * @param fechaBaja
     * @param serial
     * @return
     */
    @Override
    public ActivoFijo updateActivo(Long id, Date fechaBaja, String serial) {
        ActivoFijo activoFijo = this.findById(id);
        if (activoFijo != null) {
            activoFijo.setFechaBaja(fechaBaja);
            activoFijo.setSerial(serial);
            return activoFijoRepository.saveAndFlush(activoFijo);
        } else {
            return null;
        }
    }

}

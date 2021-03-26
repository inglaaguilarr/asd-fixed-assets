package co.com.laaguilar.services;

import co.com.laaguilar.entities.ActivoFijo;
import java.util.Date;
import java.util.List;

/**
 * Interface con las firmas de los metodos para gestionar las consultas de
 * Activo Fijo
 *
 * @author laaguilar
 */
public interface IActivoFijoService {

    List<ActivoFijo> findAll();

    ActivoFijo findById(Long id);

    ActivoFijo findByParameters(Long id, Date fechaCompra, String serial);

    List<ActivoFijo> findByDate(Date fechaCompra);

    ActivoFijo findBySerial(String serial);

    ActivoFijo saveActivo(ActivoFijo activoFijo);

    ActivoFijo updateActivo(Long id, Date fechaBaja, String serial);
}

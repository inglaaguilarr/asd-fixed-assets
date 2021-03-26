package co.com.laaguilar.services;

import co.com.laaguilar.entities.Area;
import java.util.List;

/**
 * Interface con las firmas de los metodos para gestionar las consultas de Area
 *
 * @author laaguilar
 */
public interface IAreaService {

    List<Area> findAll();
}

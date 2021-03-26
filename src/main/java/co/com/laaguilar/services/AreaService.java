package co.com.laaguilar.services;

import co.com.laaguilar.controllers.repositories.IAreaRepository;
import co.com.laaguilar.entities.Area;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para gestionar las consultas de Area
 *
 * @author laaguilar
 */
@Service
public class AreaService implements IAreaService {

    @Autowired
    private IAreaRepository areaRepository;

    @Override
    public List<Area> findAll() {
        return areaRepository.findAll();
    }

}

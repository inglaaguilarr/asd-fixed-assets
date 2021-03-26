package co.com.laaguilar.controllers.repositories;

import co.com.laaguilar.entities.ActivoFijo;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interface que permite extender las operaciones de consulta CRUD
 * proporcionadas por JpaRepository para la clase ActivoFijo
 *
 * @author laaguilar
 */
@Repository
public interface IActivoFijoRepository extends JpaRepository<ActivoFijo, Long> {

    /**
     * Firma de metodo de consulta por parametro de id, fecha de compra y serial
     * @param id Identificador del activo fijo
     * @param fechaCompra Fecha de compra del activo fijo
     * @param serial Serial asignado al activo fijo
     * @return Activo fijo no dado de baja que cumpla con los parametros de búsqueda
     */
    @Query("SELECT af FROM ActivoFijo af WHERE af.id = ?1 and af.fechaCompra = ?2 and af.serial = ?3 and af.fechaBaja is null")
    ActivoFijo findByParameters(Long id, Date fechaCompra, String serial);

    /**
     * Firma de metodo de consulta por parametro fecha de compra
     * @param fechaCompra Fecha de compra del activo fijo
     * @return Listado de activos fijos no dados de baja que coinciden con la
     * fecha de compra proporcionada
     */
    @Query("SELECT af FROM ActivoFijo af WHERE af.fechaCompra = ?1 and af.fechaBaja is null")
    List<ActivoFijo> findByDate(Date fechaCompra);

    /**
     * Firma de metodo de consulta por parametro serial
     * @param serial Serial asignado al activo fijo
     * @return Activo fijo no dado de baja que coincida con el serial proporcionado
     */
    @Query("SELECT af FROM ActivoFijo af WHERE af.serial = ?1 and af.fechaBaja is null")
    ActivoFijo findBySerial(String serial);

    /**
     * Firma de metodo de consulta por parametro de id
     * @param id Identificador del activo fijo
     * @return Activo Fijo no dado de baja
     */
    @Query("SELECT af FROM ActivoFijo af WHERE af.id = ?1 and af.fechaBaja is null")
    ActivoFijo findActById(Long id);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.laaguilar.controllers;


import co.com.laaguilar.entities.ActivoFijo;
import co.com.laaguilar.services.IActivoFijoService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
/**
 * Controlador para gestionar los recursos Rest para la clase ActivoFijo
 * @author laaguilar
 */

@RestController
@RequestMapping("/api/v1")
public class ActivoFijoController {
   
  /**
   * Servicio que provee los mecanismos de consulta para el controlador
   */  
  @Autowired
  private IActivoFijoService activoFijoService;  
    
 
    /**
     * Lista o consulta todos los Activos fijos no dados de baja
     * @return Listado de Activos Fijos
     */
    @GetMapping("/activos")
    public ResponseEntity<List<ActivoFijo>> getActivos () {
        List<ActivoFijo> activos = activoFijoService.findAll();
        return ResponseEntity.ok().body(activos);
    }
    
    /**
     * Consulta por identificador del Activo Fijo
     * @param id Identificador del activo fijo
     * @return Activo Fijo no dado de baja
     */
    @GetMapping("/activos/{id}")
    public ResponseEntity getActivoById(@PathVariable(value = "id") Long id){
        ActivoFijo activo = activoFijoService.findById(id);
        if(activo == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body(activo);
        }
    }    

    /**
     * Consulta por los parametros de identificador, fecha de compra y serial
     * @param id Identificador del activo fijo
     * @param fechaCompra Fecha de compra del activo fijo
     * @param serial Serial asignado al activo fijo
     * @return Activo fijo no dado de baja que cumpla con los parametros de búsqueda
     */
    @GetMapping("/activos/{id}/{fechaCompra}/{serial}")
    public ResponseEntity getActivoByIdFechaSerial(@PathVariable(value = "id") Long id, @PathVariable(value = "fechaCompra") String fechaCompra, @PathVariable(value = "serial") String serial){
        ActivoFijo activo = null;
            try {
                activo = activoFijoService.findByParameters(id, new SimpleDateFormat("yyyy-MM-dd").parse(fechaCompra), serial);
            } catch (ParseException ex) {
                Logger.getLogger(ActivoFijoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        if(activo == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body(activo);
        }
    }
    
    /**
     * Consulta por fecha de compra
     * @param fechaCompra Fecha de compra del activo fijo
     * @return Listado de activos fijos no dados de baja que coinciden con la
     * fecha de compra proporcionada
     */
    @GetMapping("/activos/fecha/{fechaCompra}")
    public ResponseEntity getActivoByFecha(@PathVariable(value = "fechaCompra") String fechaCompra){
        List<ActivoFijo> activos = null;
            try {
                activos = activoFijoService.findByDate(new SimpleDateFormat("yyyy-MM-dd").parse(fechaCompra));
            } catch (ParseException ex) {
                Logger.getLogger(ActivoFijoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        if(activos == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body(activos);
        }
    }
    
    /**
     * Consulta por serial
     * @param serial Serial asignado al activo fijo
     * @return Activo fijo no dado de baja que coincida con el serial proporcionado
     */
    @GetMapping("/activos/serial/{serial}")
    public ResponseEntity getActivoBySerial(@PathVariable(value = "serial") String serial){
        ActivoFijo activo = activoFijoService.findBySerial(serial);
        if(activo == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body(activo);
        }
    }
    
    /**
     * Creación de activo fijo
     * @param activoFijo Estructura de activo fijo.
     * @return  Confirmación de activo fijo almacenado
     */
    @PostMapping("/activos")
    public ResponseEntity<ActivoFijo> createActivo(@Valid @RequestBody ActivoFijo activoFijo) {
        ActivoFijo activo;
        try{
            activo = activoFijoService.saveActivo(activoFijo);
            //activo = activoFijoService.findById(activo.getId());
            if(activo!=null){
                return ResponseEntity.ok(activo);
            }else{
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch(Exception ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
     * Actualización de activo fijo
     * @param id Identificador del activo fijo
     * @param activoUpdate Estructura de activo fijo, solo tiene en cuenta la fecha de baja y/o serial.
     * @return  Confirmación de activo fijo actualizado
     */
    @PutMapping("/activos/{id}")    
    public ResponseEntity<ActivoFijo> updateActivo(
      @PathVariable(value = "id") Long id, @Valid @RequestBody ActivoFijo activoUpdate) {
      ActivoFijo activo;
        try{
            activo = activoFijoService.updateActivo(id, activoUpdate.getFechaBajaAut(), activoUpdate.getSerial());
            //activo = activoFijoService.findById(id);
            if(activo!=null){
                return ResponseEntity.ok(activo);
            }else{
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            
        }catch(Exception ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
       
  }    
}

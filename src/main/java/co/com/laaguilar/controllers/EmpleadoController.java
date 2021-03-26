/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.laaguilar.controllers;

import co.com.laaguilar.services.IEmpleadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.laaguilar.entities.Empleado;
import org.springframework.http.ResponseEntity;

/**
 * Controlador para gestionar los recursos Rest para la clase Empleado
 * @author laaguilar
 */
@RestController
@RequestMapping("/api/v1")
public class EmpleadoController {

  /**
   * Servicio que provee los mecanismos de consulta para el controlador
   */      
  @Autowired
  private IEmpleadoService empleadoService;     
  
    /**
     * Lista o consulta todas las personas o empleados de la compañia
     * @return Listado de Personas
     */  
    @GetMapping("/personas")
    public ResponseEntity<List<Empleado>> getEmpleados () {
        List<Empleado> empleados = empleadoService.findAll();
        return ResponseEntity.ok().body(empleados);
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.laaguilar.controllers;

import co.com.laaguilar.services.IAreaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.laaguilar.entities.Area;
import org.springframework.http.ResponseEntity;

/**
 * Controlador para gestionar los recursos Rest para la clase Area
 * @author laaguilar
 */
@RestController
@RequestMapping("/api/v1")
public class AreaController {
    
  /**
   * Servicio que provee los mecanismos de consulta para el controlador
   */  
  @Autowired
  private IAreaService areaService;      
  
    /**
     * Lista o consulta todas las Areas de la compañia
     * @return Listado de Areas
     */
    @GetMapping("/areas")
    public ResponseEntity<List<Area>> getAreas () {
        List<Area> areas = areaService.findAll();
        return ResponseEntity.ok().body(areas);
    }
}

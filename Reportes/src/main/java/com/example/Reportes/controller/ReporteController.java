package com.example.Reportes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Reportes.model.Reporte;
import com.example.Reportes.service.ReporteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService svc;
    // Crear un nuevo reporte -- cliente
    
    @PostMapping
    public Reporte crear(@Valid @RequestBody Reporte r) {
        return svc.crear(r);
    }
    // Obtener todos los reportes -- cliente -- admin -- tecnico
    @GetMapping
    public List<Reporte> listar() {
        return svc.obtenerTodos();
    }
    // Obtener un reporte por id -- cliente -- tecnico -- admin
    @GetMapping("/{id}")
    public ResponseEntity<Reporte> obtener(@PathVariable Long id) {
        Reporte r = svc.obtenerPorId(id);
        return r != null ? ResponseEntity.ok(r) : ResponseEntity.notFound().build();
    }

    // Eliminar un reporte por id -- admin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        svc.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

}

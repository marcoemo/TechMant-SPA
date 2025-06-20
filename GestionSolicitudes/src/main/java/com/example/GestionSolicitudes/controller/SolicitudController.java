package com.example.GestionSolicitudes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.GestionSolicitudes.model.Solicitud;
import com.example.GestionSolicitudes.service.SolicitudService;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

    private final SolicitudService svc;

    public SolicitudController(SolicitudService svc) {
        this.svc = svc;
    }

    //tecnico -- supervisor
    // Obtener todas las solicitudes
    @GetMapping
    public List<Solicitud> obtenerSolicitudes() {
        return svc.obtenerTodas();
    }
    // Obtener una solicitud por ID
    // tecnico -- supervisor --cliente
    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> obtener(@PathVariable Long id){
        return svc.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    // Crear una nueva solicitud -- cliente
    @PostMapping
    public Solicitud crear(@RequestBody Solicitud solicitud) {
        return svc.crearS(solicitud);
    }
    // Cambiar el estado de una solicitud -- tecnico
    @PutMapping("/{id}/estado")
    public ResponseEntity<Solicitud> cambiarEstado(
            @PathVariable Long id,
            @RequestParam String estado) {

        try {
            Solicitud actualizada = svc.cambiarEstado(id, estado);
            return ResponseEntity.ok(actualizada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    // Modificar una solicitud -- tecnico -- fecha de cierre
    @PutMapping("/{id}")
    public ResponseEntity<Solicitud> actualizar(@PathVariable Long id, @RequestBody Solicitud solicitud) {
        return svc.actualizar(id, solicitud)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    // Eliminar una solicitud por ID -- tecnico 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return svc.eliminar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    // Filtrar solicitudes por usuario -- tecnico -- supervisor
    @GetMapping("/usuario/{usuarioId}")
    public List<Solicitud> obtenerPorUsuario(@PathVariable Long usuarioId) {
        return svc.filtrarPorUsuario(usuarioId);
    }
    // Filtrar solicitudes por técnico asignado -- supervisor
    @GetMapping("/tecnico/{idAsignacion}")
    public List<Solicitud> obtenerPorTecnico(@PathVariable Long idAsignacion) {
        return svc.filtrarPorTecnico(idAsignacion);
    }

}

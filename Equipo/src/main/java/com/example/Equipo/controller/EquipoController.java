package com.example.Equipo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Equipo.model.Equipo;
import com.example.Equipo.service.EquipoService;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoService svc;
    // Crear un nuevo equipo -- cliente
    @PostMapping
    public Equipo crear(@RequestBody Equipo e) {
        return svc.crear(e);
    }
    // Listar todos los equipos -- tecnico -- admin
    @GetMapping
    public List<Equipo> listar() {
        return svc.obtenerTodos();
    }

    // Obtener un equipo por id -- tecnico -- admin
    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtener(@PathVariable Long id) {
        Equipo e = svc.obtenerPorId(id);
        return e != null ? ResponseEntity.ok(e) : ResponseEntity.notFound().build();
    }

    // Buscar equipos por usuario -- cliente
    @GetMapping("/usuario/{usuarioId}")
    public List<Equipo> buscarPorUsuario(@PathVariable Long usuarioId) {
        return svc.buscarPorUsuario(usuarioId);
    }
    // Actualizar un equipo por id -- cliente
    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizar(@PathVariable Long id, @RequestBody Equipo e) {
        Equipo actualizado = svc.actualizar(id, e);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }
    // Eliminar un equipo por id -- cliente -- admin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        svc.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}

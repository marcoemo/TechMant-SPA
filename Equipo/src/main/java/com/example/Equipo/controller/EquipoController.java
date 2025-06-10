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

    @PostMapping
    public Equipo crear(@RequestBody Equipo e) {
        return svc.crear(e);
    }

    @GetMapping
    public List<Equipo> listar() {
        return svc.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtener(@PathVariable Long id) {
        Equipo e = svc.obtenerPorId(id);
        return e != null ? ResponseEntity.ok(e) : ResponseEntity.notFound().build();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Equipo> buscarPorUsuario(@PathVariable Long usuarioId) {
        return svc.buscarPorUsuario(usuarioId);
    }
}

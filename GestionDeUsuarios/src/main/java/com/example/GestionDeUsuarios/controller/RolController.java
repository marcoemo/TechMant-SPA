package com.example.GestionDeUsuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestionDeUsuarios.model.Rol;
import com.example.GestionDeUsuarios.service.RolService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/roles")
public class RolController {
    
    @Autowired
    private final RolService RS;

    public RolController(RolService RS){
        this.RS=RS;
    }
    // Endpoint para buscar rol por id -- admin
    @GetMapping()
    public ResponseEntity<List<Rol>> obtenerTodos() {
        return ResponseEntity.ok(RS.obtenerTodos());
    }

    //crear un nuevo rol -- admin
    @PostMapping
    public Rol agregaRol(@RequestBody Rol r) {
        return RS.agregarRol(r);
    }

    //eliminar un rol por id -- admin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(Long id) {
        RS.eliminarRol(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para buscar rol por id -- admin
    @GetMapping("/{id}")
    public ResponseEntity<Rol> buscarPorId(Long id) {
        Rol rol = RS.buscarPorId(id);
        return rol != null ? ResponseEntity.ok(rol) : ResponseEntity.notFound().build();
    }

    // Endpoint para actualizar rol por id -- admin
    @PutMapping("/{id}")
    public ResponseEntity<Rol> actualizarRol(Long id, @RequestBody Rol r) {
        Rol rolActualizado = RS.actualizarRol(id, r);
        return rolActualizado != null ? ResponseEntity.ok(rolActualizado) : ResponseEntity.notFound().build();
    }
}

package com.example.Equipo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Equipo.model.Categoria;
import com.example.Equipo.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService svc;

    // Crear una nueva categoria -- admin -- tecnico
    @PostMapping
    public Categoria crear(@RequestBody Categoria c) {
        return svc.crear(c);
    }
    // Listar todas las categorias -- admin -- tecnico -- cliente
    @GetMapping
    public List<Categoria> listar() {
        return svc.obtenerTodas();
    }
    
    // Obtener una categoria por id -- admin -- tecnico
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtener(@PathVariable Long id) {
        Categoria c = svc.obtenerPorId(id);
        return c != null ? ResponseEntity.ok(c) : ResponseEntity.notFound().build();
    }
    //actualizar una categoria -- admin -- tecnico
    @PostMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Long id, @RequestBody Categoria c) {
        Categoria actualizado = svc.actualizar(id, c);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }
    //eliminar una categoria -- admin -- tecnico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        svc.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
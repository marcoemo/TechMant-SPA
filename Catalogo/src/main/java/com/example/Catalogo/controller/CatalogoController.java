package com.example.Catalogo.controller;

import com.example.Catalogo.model.Catalogo;
import com.example.Catalogo.service.CatalogoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogos")
public class CatalogoController {

    @Autowired
    private CatalogoService catalogoService;

    //ver todos los catalogos -- tecnico -- admin
    @GetMapping
    public List<Catalogo> obtenerTodos() {
        return catalogoService.obtenerTodos();
    }
    //ver catalogo por id -- tecnico -- admin
    @GetMapping("/{id}")
    public ResponseEntity<Catalogo> obtenerPorId(@PathVariable Long id) {
        Catalogo catalogo = catalogoService.obtenerPorId(id);
        if (catalogo != null) {
            return ResponseEntity.ok(catalogo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // eliminar catalogo por id -- tecnico -- admin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        boolean eliminado = catalogoService.eliminarPorId(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
// crear un nuevo catalogo -- tecnico -- admin
    @PostMapping
    public ResponseEntity<Catalogo> agregarCatalogo(@RequestBody Catalogo catalogo) {
        Catalogo nuevoCatalogo = catalogoService.agregarCatalogo(catalogo);
        return ResponseEntity.status(201).body(nuevoCatalogo);
    }
// actualizar catalogo por id -- tecnico -- admin
    @PutMapping("/{id}")
    public ResponseEntity<Catalogo> actualizarCatalogo(@PathVariable Long id, @RequestBody Catalogo catalogo) {
        Catalogo actualizado = catalogoService.actualizarCatalogo(id, catalogo);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
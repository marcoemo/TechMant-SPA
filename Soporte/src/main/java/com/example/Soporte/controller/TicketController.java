package com.example.Soporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Soporte.model.Ticket;
import com.example.Soporte.service.TicketService;

@RestController
@RequestMapping("ticket")
public class TicketController {
    @Autowired
    private TicketService TS;

    // endpoint para ver todos los tickets -- Usuario
    @GetMapping
    public ResponseEntity<List<Ticket>> obtenerTicket() {
        List<Ticket> tickets = TS.getTicket();
        if (tickets.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(tickets);
        }

    }
    // endpoint para buscar ticket por id Supervisor tecnico
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> obtenerTicket(@PathVariable Long id) {
        try {
            Ticket ticket = TS.getTicket(id);
            return ResponseEntity.ok(ticket);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // endpoint para crear ticket Usuario
    @PostMapping
    public ResponseEntity<Ticket> guardarTicket(@RequestBody Ticket nuevo) {
        return ResponseEntity.status(201).body(TS.saveTicket(nuevo));
    }

    // endpoint para buscar tickets por usuario -- usuario
     @GetMapping("/usuario/{usuarioId}")
    public List<Ticket> ticketsPorUsuario(@PathVariable Long usuarioId) {
        return TS.getTicketsPorUsuario(usuarioId);
    }
    // endpoint para actualizar ticket por id -- supervisor tecnico
     @PutMapping("/{id}")
    public ResponseEntity<Ticket> actualizar(@PathVariable Long id, @RequestBody Ticket nuevo) {
        return ResponseEntity.ok(TS.actualizarTicket(id, nuevo));
    }
    // endpoint para eliminar ticket por id -- supervisor tecnico
     @DeleteMapping("/{id}") // supervisor tecnico
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        TS.eliminarTicket(id);
        return ResponseEntity.noContent().build();
    }

}

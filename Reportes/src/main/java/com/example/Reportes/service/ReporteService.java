package com.example.Reportes.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Reportes.model.Reporte;
import com.example.Reportes.repository.ReporteRepository;

@Service
public class ReporteService {
    private final ReporteRepository repo;

    public ReporteService(ReporteRepository repo) {
        this.repo = repo;
    }
    
    //crear un nuevo reporte -- cliente
    public Reporte crear(Reporte r) {
        r.setFechaGeneracion(LocalDate.now());
        return repo.save(r);
    }

    //obtener todos los reportes -- cliente -- admin -- tencnico
    public List<Reporte> obtenerTodos() {
        return repo.findAll();
    }

    //obtener un reporte por id -- cliente -- tecnico -- admin
    public Reporte obtenerPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    //eliminar un reporte por id -- admin -- cliente
    public void eliminarPorId(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
    }
}
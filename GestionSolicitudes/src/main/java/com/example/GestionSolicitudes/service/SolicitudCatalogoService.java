package com.example.GestionSolicitudes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.GestionSolicitudes.model.SolicitudCatalogo;
import com.example.GestionSolicitudes.model.SolicitudCatalogoId;
import com.example.GestionSolicitudes.repository.SolicitudCatalogoRepository;

@Service
public class SolicitudCatalogoService {

    private final SolicitudCatalogoRepository solCatRepo;

    public SolicitudCatalogoService(SolicitudCatalogoRepository solCatRepo) {
        this.solCatRepo = solCatRepo;
    }

    //guardar vinculo entre solicitud y catalogo
    public SolicitudCatalogo crearV(SolicitudCatalogo relacion){
        return solCatRepo.save(relacion);
    }

    //listar todos los vinculos
    public List<SolicitudCatalogo> obtenerTodos() {
        return solCatRepo.findAll();
    }

    //busca relacion especifica por su clave compuesta
    public Optional<SolicitudCatalogo> obtenerPorId(SolicitudCatalogoId id) {
        return solCatRepo.findById(id);
    }

    //eliminar relacion ??
}

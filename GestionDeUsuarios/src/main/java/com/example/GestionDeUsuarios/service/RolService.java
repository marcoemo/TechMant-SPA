package com.example.GestionDeUsuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GestionDeUsuarios.model.Rol;
import com.example.GestionDeUsuarios.repository.RolRepository;

import jakarta.annotation.PostConstruct;

@Service
public class RolService {
    @Autowired
    private final RolRepository RP;

    public RolService(RolRepository RP) {
        this.RP = RP;
    }

    @PostConstruct
    public void CargarRolesIniciales() {
        if (!RP.existsById(1L)) {
            RP.save(new Rol(1L, "ADMINISTRADOR"));
        }
        if (!RP.existsById(2L)) {
            RP.save(new Rol(2L, "TECNICO"));
        }
        if (!RP.existsById(3L)) {
            RP.save(new Rol(3L, "SUPERVISOR"));
        }
        if (!RP.existsById(4L)) {
            RP.save(new Rol(4L, "SOPORTE"));
        }
        if (!RP.existsById(5L)) {
            RP.save(new Rol(5L, "USUARIO"));
        }
    }
    
      public List<Rol> obtenerTodos() {
        return RP.findAll();
    }
    
    //agregar un nuevo rol
    public Rol agregarRol(Rol rol) {
        return RP.save(rol);
    }

    //eliminar un rol por id
    public boolean eliminarRol(Long id) {
        if (RP.existsById(id)) {
            RP.deleteById(id);
            return true;
        }
        return false;
    }

    //buscar rol por id
    public Rol buscarPorId(Long id) {
        return RP.findById(id).orElse(null);
    }

    //actualizar rol por id
    public Rol actualizarRol(Long id, Rol nuevoRol) {
        Rol actual = buscarPorId(id);
        if (actual != null) {
            actual.setNombreRol(nuevoRol.getNombreRol());
            return RP.save(actual);
        }
        return null;
    }
}

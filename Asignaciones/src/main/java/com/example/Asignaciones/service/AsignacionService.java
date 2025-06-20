package com.example.Asignaciones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Asignaciones.model.Tecnico;
import com.example.Asignaciones.repository.AsignacionRepository;

@Service
public class AsignacionService {
    @Autowired
    private AsignacionRepository AR;

    private Long proximoId = 4L;

    public void cargarTecnicosIniciales(){
        if (AR.count() == 0) {
            AR.save(new Tecnico(1L, "Ricardo","Disponible",1L));
            AR.save(new Tecnico(2L, "Dariel","Ocupado",2L));
            AR.save(new Tecnico(3L, "Carlos","Disponible",3L));
            
        }
    }
    // Obtener todos los técnicos --supervisor -- admin
    public List<Tecnico> obtenerTodos(){
        return AR.findAll();
    }
    // Buscar por ID -- supervisor -- admin
    public Tecnico buscarPorId(Long id) {
        return AR.findById(id).orElse(null);
    }

    // Eliminar -- supervisor -- admin
    public void eliminarPorId(Long id) {
        if (AR.existsById(id)) {
            AR.deleteById(id);
        }
    }

    // Modificar disponibilidad por ID -- supervisor -- admin
    public void modificarDisponibilidad(Long id, String nuevaDisponibilidad) {
        Tecnico tecnico = AR.findById(id).orElse(null);
        if (tecnico != null) {
            tecnico.setDisponibilidad(nuevaDisponibilidad);
            AR.save(tecnico);
        }
    }
    // Agregar un nuevo -- supervisor -- admin
    public Tecnico agregarTecnico(String nombre, String disponibilidad) {
        Tecnico nuevo = new Tecnico(proximoId, nombre, disponibilidad, proximoId);
        AR.save(nuevo);
        proximoId++;
        return nuevo;
    }
}
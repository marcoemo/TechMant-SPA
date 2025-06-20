package com.example.Catalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Catalogo.model.Catalogo;
import com.example.Catalogo.repository.CatalogoRepository;

import jakarta.annotation.PostConstruct;

@Service
public class CatalogoService {

    @Autowired
    private final CatalogoRepository CR;

    private CatalogoService(CatalogoRepository CR){
            this.CR=CR;
    }
    @PostConstruct
    public void CargarServiciosInciales(){

       if(!CR.existsById(1L)){
            CR.save(new Catalogo(1L,"Reparación","Reparación de fallas de hardware y software en notebooks.", 20000));
        }
        if(!CR.existsById(2L)){
            CR.save(new Catalogo(2L,"Instalación de software","Instalación y configuración de programas y sistemas.",10000));

        }
        if(!CR.existsById(3L)){
            CR.save(new Catalogo(3L,"Mantenimiento preventivo de equipos","Revisión y limpieza para prevenir fallas técnicas.",15000));

        }
        if(!CR.existsById(4L)){
            CR.save(new Catalogo(4L,"Formateo y respaldo de datos","Respaldo de archivos y formateo completo del equipo.",19990));
        }
        if(!CR.existsById(5L)){
            CR.save(new Catalogo(5L,"Revisión técnica de hardware","Chequeo de componentes internos y funcionamiento.",23500));
        }
        if(!CR.existsById(6L)){
            CR.save(new Catalogo(6L,"Limpieza interna de equipos","Limpieza física interna para mejorar rendimiento.",15990));
        }
        if(!CR.existsById(7L)){
            CR.save(new Catalogo(7L,"Diagnóstico general","Evaluación completa del equipo y sus fallas.",30000));
        }
        if(!CR.existsById(8L)){
            CR.save(new Catalogo(8L,"Configuración de red local","Instalación y ajuste de redes domésticas u oficina.",50000));
        }
        if(!CR.existsById(9L)){
            CR.save(new Catalogo(9L,"Asesoría en compras de tecnología","Recomendaciones para adquirir tecnología adecuada.",10000));
        }
    }

    // obtener todos los servicios del catálogo -- administrador
    public List<Catalogo> obtenerTodos(){
        return CR.findAll();
    }

    // obtener por id -- administrador
    public Catalogo obtenerPorId(Long id){
        return CR.findById(id).orElse(null);
    }

    //eliminar un servicio del catálogo por id  -- administrador
    public boolean eliminarPorId(Long id){
        if(CR.existsById(id)){
            CR.deleteById(id); 
            return true;
        }
        return false;
    }

    //agregar un nuevo servicio al catálogo -- administrador
    public Catalogo agregarCatalogo(Catalogo catalogo){
        return CR.save(catalogo);
    }

    //actualizar un servicio del catálogo por id -- administrador
    public Catalogo actualizarCatalogo(Long id, Catalogo nuevoCatalogo) {
        Catalogo actual = obtenerPorId(id);
        if (actual != null) {
            actual.setNombre(nuevoCatalogo.getNombre());
            actual.setDescripcion(nuevoCatalogo.getDescripcion());
            actual.setPrecio(nuevoCatalogo.getPrecio());
            return CR.save(actual);
        }
        return null;
    }
    
}

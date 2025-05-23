package com.example.GestionSolicitudes.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.GestionSolicitudes.client.DiagnosticoClient;
import com.example.GestionSolicitudes.model.Solicitud;
import com.example.GestionSolicitudes.model.SolicitudEstado;
import com.example.GestionSolicitudes.repository.SolicitudRepository;

@Service
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;
    private final DiagnosticoClient diagnosticoClient;

    public SolicitudService(SolicitudRepository solicitudRepository, DiagnosticoClient diagnosticoClient) {
        this.solicitudRepository = solicitudRepository;
        this.diagnosticoClient = diagnosticoClient;
    }

    public Map<String, Object> obtenerDetalleSolicitudConDiagnostico(Long solicitudId) {
        var solicitud = solicitudRepository.findById(solicitudId).orElse(null);
        if (solicitud == null) return null;

        Map<String, Object> diagnostico = diagnosticoClient.obtenerDiagnosticoPorId(solicitud.getDiagnosticoId());

        return Map.of(
            "solicitud", solicitud,
            "diagnostico", diagnostico
        );
    }

    //Crear una nueva solicitud con la fecha actual
    public Solicitud crearS(Solicitud solicitud) {
        solicitud.setFechaCreacion(LocalDate.now());
        return solicitudRepository.save(solicitud);
    }

    //obtener todas las solicitudes
    public List<Solicitud> obtenerTodas() {
        return solicitudRepository.findAll();
    }

    //obtener una solicitud por id
    public Optional<Solicitud> obtenerPorId(Long id) {
        return solicitudRepository.findById(id);
    }

    //Cambiar estado de la solicitud
    public Solicitud cambiarEstado(Long id, String estadoTexto) {
    Solicitud solicitud = solicitudRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Solicitud no encontrada"));

    SolicitudEstado nuevoEstado = SolicitudEstado.valueOf(estadoTexto.toUpperCase());
    solicitud.setEstado(nuevoEstado);

    return solicitudRepository.save(solicitud);
    }

}

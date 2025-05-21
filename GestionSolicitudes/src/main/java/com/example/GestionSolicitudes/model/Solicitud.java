package com.example.GestionSolicitudes.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "solicitudes")
@AllArgsConstructor
@NoArgsConstructor

public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long solicitudId;
  
    @Column(nullable = false, length = 500, name = "descripcion_problema")
    private String descripcionProblema;

    @Column(nullable = false, name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(nullable = true, name = "fecha_resolucion")
    private LocalDateTime fechaCierre;

    @Column(nullable = false, name = "costo_estimado")
    private int  costoEstimado;

    @Column(nullable = false, name = "costo_real")
    private int total;

    @Enumerated(EnumType.STRING)
    private SolicitudEstado estado; // Enum con los estados de la solicitud
   
    private Long diagnosticoId;   // Fk
}

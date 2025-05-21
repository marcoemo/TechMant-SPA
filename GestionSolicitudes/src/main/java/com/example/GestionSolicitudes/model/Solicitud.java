package com.example.GestionSolicitudes.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(nullable = false, name = "fecha_resolucion")
    private LocalDateTime fechaCierre;

    @Column(nullable = false, name = "costo_estimado")
    private int  costoEstimado;

    @Column(nullable = false, name = "costo_real")
    private int total;

    private Long usuarioId;            // FK
    private Long estadoId;             // FK 
    //@Enumerated(EnumType.STRING)
    //private SolicitudEstado estado; M:M con servicio
}

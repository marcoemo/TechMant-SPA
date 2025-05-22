package com.example.GestionSolicitudes.model;

import java.sql.Date;
import java.time.LocalDate;

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
    private LocalDate fechaCreacion;

    @Column(nullable = true, name = "fecha_resolucion")
    private Date fechaCierre;

    @Column(nullable = false, name = "costo_estimado")
    private int  costoEstimado;

    @Column(nullable = false, name = "costo_real")
    private int total;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "estado")
    private SolicitudEstado estado; // Enum con los estados de la solicitud
   
    private Long diagnosticoId;   // Fk de diagnostico

    private Long idUsuario; // Fk de usuario (referencia)

}


// {
//   "usuarioId": 1,
//   "equipoId": 2,

//   "descripcionProblema": "No enciende el equipo",
//   "estado": "NUEVA",
//   "costoEstimado": 0,
//   "total": 0,
//   "diagnosticoId": null
// }
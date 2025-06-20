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
  
    @Column(nullable = false, length = 500)
    private String descripcionProblema;

    @Column(nullable = false)
    private LocalDate fechaCreacion;

    @Column(nullable = false)
    private Date fechaCierre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SolicitudEstado estado; // Enum con los estados de la solicitud

    private Long idAsignacion; // Fk de tecnico (referencia)

    private Long reporteId; // Fk de reporte (referencia)
    
    private Long usuarioId;    //  Usuario que creó la solicitud

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
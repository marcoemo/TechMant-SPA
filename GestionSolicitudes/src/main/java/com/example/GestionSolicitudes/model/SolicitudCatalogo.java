package com.example.GestionSolicitudes.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "solicitudes_servicios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudCatalogo {

    @EmbeddedId
    private SolicitudCatalogoId id;

    @ManyToOne
    @MapsId("solicitudId")
    @JoinColumn(name = "solicitud_id")
    private Solicitud solicitud;//fk solicitud
    
    @Column(name = "Id_catalogo", insertable = false, updatable = false)
    private Long idCatalogo; //fk servicio

    @Column(nullable = false)
    private int subtotal; //atributo de la tabla intermedia
}
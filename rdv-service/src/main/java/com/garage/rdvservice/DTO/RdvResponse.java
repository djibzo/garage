package com.garage.rdvservice.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class RdvResponse {
    private Long id;

    private String description;

    private LocalDateTime dateHeure;

    private String statut;
    private Long id_vehicule;
}

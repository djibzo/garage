package com.garage.rdvservice.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRdvRequest {
    private Long id;

    private String description;

    private LocalDateTime dateHeure;

    private String statut;
    private Long id_vehicule;
}

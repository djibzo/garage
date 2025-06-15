package com.garage.vehiculeservice.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VehiculeResponse {
    private Long id;

    private String marque;
    private String modele;
    private String immatriculation;

    private Long id_client;
}

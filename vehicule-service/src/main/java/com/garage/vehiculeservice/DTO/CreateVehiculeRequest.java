package com.garage.vehiculeservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateVehiculeRequest {
    private Long id;

    private String marque;
    private String modele;
    private String immatriculation;

    private Long id_client;
}

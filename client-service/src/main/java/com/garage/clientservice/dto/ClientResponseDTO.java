package com.garage.clientservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientResponseDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
}

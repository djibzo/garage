package com.garage.clientservice.dto;

import lombok.*;


import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateClientRequest {

    private String nom;

    private String prenom;

    private String email;

    private String telephone;

    private String password;
}

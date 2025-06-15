package com.garage.rdvservice.Entities;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rdv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDateTime dateHeure;

    private String statut;
    private Long id_vehicule;
}

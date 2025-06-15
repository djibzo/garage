package com.garage.vehiculeservice.Repositories;

import com.garage.vehiculeservice.Entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {
}

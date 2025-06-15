package com.garage.rdvservice.Repository;

import com.garage.rdvservice.Entities.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RdvRepository extends JpaRepository<Rdv,Long> {
}

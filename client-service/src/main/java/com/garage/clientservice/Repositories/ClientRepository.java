package com.garage.clientservice.Repositories;

import com.garage.clientservice.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}


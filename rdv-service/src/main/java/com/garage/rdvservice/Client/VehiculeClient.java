package com.garage.rdvservice.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "vehicule-service")
public interface VehiculeClient {

    @GetMapping("/vehicules/{id}")

    Object getVehiculeById(@PathVariable("id") Long id);
}



package com.garage.vehiculeservice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiculeController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello from Vehicule Service";
    }
}

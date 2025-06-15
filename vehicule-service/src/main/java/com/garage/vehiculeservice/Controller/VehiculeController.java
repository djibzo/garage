package com.garage.vehiculeservice.Controller;

import com.garage.vehiculeservice.DTO.CreateVehiculeRequest;
import com.garage.vehiculeservice.Entities.Vehicule;
import com.garage.vehiculeservice.Services.VehiculeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vehicules")
public class VehiculeController {
    private final VehiculeService vehiculeService;
    @GetMapping()
    public ResponseEntity<List<Vehicule>> getAllVehicules(){
       List<Vehicule> vehicules =  vehiculeService.getAllVehicules();
       return ResponseEntity.ok(vehicules);
    }
    @PostMapping
    public ResponseEntity<Vehicule> createVehicule(@RequestBody CreateVehiculeRequest request) {
        Vehicule createdVehicule = vehiculeService.createVehicule(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicule);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> getVehiculeById(@PathVariable Long id) {
        Vehicule vehicule = vehiculeService.getVehiculeById(id);
        if (vehicule == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicule);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicule(@PathVariable Long id) {
        vehiculeService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<CreateVehiculeRequest> updateVehicule(@PathVariable Long id, @RequestBody CreateVehiculeRequest request) {
        vehiculeService.updateVehicule(id, request);
        return ResponseEntity.ok(request);
    }
}

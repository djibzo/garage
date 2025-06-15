package com.garage.rdvservice.Controller;


import com.garage.rdvservice.DTO.CreateRdvRequest;
import com.garage.rdvservice.Entities.Rdv;
import com.garage.rdvservice.Service.RdvService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rdvs")
public class RdvController {
    private final RdvService rdvService;
    @GetMapping()
    public ResponseEntity<List<Rdv>> getAllRdv(){
        List<Rdv> rdvs =  rdvService.getAllRdv();
        return ResponseEntity.ok(rdvs);
    }
    @PostMapping
    public ResponseEntity<Rdv> createRdv(@RequestBody CreateRdvRequest request) {
        Rdv createdRdv = rdvService.createRdv(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRdv);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Rdv> getRdvById(@PathVariable Long id) {
        Rdv rdv = rdvService.getRdvById(id);
        if (rdv == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rdv);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRdv(@PathVariable Long id) {
        rdvService.deleteRdv(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<CreateRdvRequest> updateRdv(@PathVariable Long id, @RequestBody CreateRdvRequest request) {
        rdvService.updateRdv(id, request);
        return ResponseEntity.ok(request);
    }
}

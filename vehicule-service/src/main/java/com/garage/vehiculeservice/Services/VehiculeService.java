package com.garage.vehiculeservice.Services;

import com.garage.vehiculeservice.DTO.CreateVehiculeRequest;
import com.garage.vehiculeservice.DTO.VehiculeResponse;
import com.garage.vehiculeservice.Entities.Vehicule;
import com.garage.vehiculeservice.Repositories.VehiculeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculeService {
    private final VehiculeRepository vehiculeRepository;

    public VehiculeService(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }
    public Vehicule createVehicule(CreateVehiculeRequest request){
        //Verfier si le client existe
        Vehicule vehicule = new Vehicule();
        vehicule.setMarque(request.getMarque());
        vehicule.setModele(request.getModele());
        vehicule.setImmatriculation(request.getImmatriculation());
        vehicule.setId_client(request.getId_client());

        return vehiculeRepository.save(vehicule);
    }
    public List<Vehicule> getAllVehicules(){
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        return vehicules;
    }
    public void deleteVehicle(Long id){
        vehiculeRepository.deleteById(id);
    }
    public Vehicule getVehiculeById(Long id) {
        Vehicule vehicule = vehiculeRepository.findById(id).orElse(null);
        if (vehicule == null) {
            return null; // or throw an exception
        }
        return new Vehicule(vehicule.getId(), vehicule.getMarque(), vehicule.getModele(), vehicule.getImmatriculation(), vehicule.getId_client());
    }
    public void updateVehicule(Long id, CreateVehiculeRequest request) {
        Vehicule vehicule = vehiculeRepository.findById(id).orElse(null);
        if (vehicule != null) {
            vehicule.setMarque(request.getMarque());
            vehicule.setModele(request.getModele());
            vehicule.setImmatriculation(request.getImmatriculation());
            vehicule.setId_client(request.getId_client());
            vehiculeRepository.save(vehicule);
        }
    }
}

package com.garage.rdvservice.Service;

import com.garage.rdvservice.Client.VehiculeClient;
import com.garage.rdvservice.DTO.CreateRdvRequest;
import com.garage.rdvservice.Entities.Rdv;
import com.garage.rdvservice.Repository.RdvRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RdvService {
    //@Autowired
    private VehiculeClient vehiculeClient;
    private final RdvRepository rdvRepository;


    public RdvService(RdvRepository rdvRepository) {
        this.rdvRepository = rdvRepository;
    }
    public Rdv createRdv(CreateRdvRequest request){
       /* try {
            vehiculeClient.getVehiculeById(request.getId_vehicule());
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("Vehicule inexistant");
        }*/
        Rdv rdv = new Rdv();
        rdv.setDateHeure(request.getDateHeure());
        rdv.setStatut(request.getStatut());
        rdv.setDescription(request.getDescription());
        rdv.setId_vehicule(request.getId_vehicule());

        return rdvRepository.save(rdv);
    }
    public List<Rdv> getAllRdv(){
        List<Rdv> rdvs = rdvRepository.findAll();
        return rdvs;
    }
    public void deleteRdv(Long id){
        rdvRepository.deleteById(id);
    }
    public Rdv getRdvById(Long id) {
        Rdv rdv = rdvRepository.findById(id).orElse(null);
        if (rdv == null) {
            return null; // or throw an exception
        }
        return new Rdv(rdv.getId(), rdv.getDescription(), rdv.getDateHeure(), rdv.getStatut() ,rdv.getId_vehicule());
    }
    public void updateRdv(Long id, CreateRdvRequest request) {
        Rdv rdv = rdvRepository.findById(id).orElse(null);
        if (rdv != null) {
            rdv.setStatut(request.getStatut());
            rdv.setDescription(request.getDescription());
            rdv.setDateHeure(request.getDateHeure());
            rdv.setId_vehicule(request.getId_vehicule());
            rdvRepository.save(rdv);
        }
    }
}
